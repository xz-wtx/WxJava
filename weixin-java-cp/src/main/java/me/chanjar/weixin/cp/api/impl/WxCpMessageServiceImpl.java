package me.chanjar.weixin.cp.api.impl;

import lombok.RequiredArgsConstructor;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpMessageService;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.message.WxCpLinkedCorpMessage;
import me.chanjar.weixin.cp.bean.message.WxCpMessage;
import me.chanjar.weixin.cp.bean.message.WxCpMessageSendResult;
import me.chanjar.weixin.cp.constant.WxCpApiPathConsts;

/**
 * 消息推送接口实现类.
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 * @date 2020-08-30
 */
@RequiredArgsConstructor
public class WxCpMessageServiceImpl implements WxCpMessageService {
  private final WxCpService cpService;

  @Override
  public WxCpMessageSendResult send(WxCpMessage message) throws WxErrorException {
    Integer agentId = message.getAgentId();
    if (null == agentId) {
      message.setAgentId(this.cpService.getWxCpConfigStorage().getAgentId());
    }

    return WxCpMessageSendResult.fromJson(this.cpService.post(this.cpService.getWxCpConfigStorage()
      .getApiUrl(WxCpApiPathConsts.Message.MESSAGE_SEND), message.toJson()));
  }

  @Override
  public WxCpMessageSendResult sendLinkedCorpMessage(WxCpLinkedCorpMessage message) throws WxErrorException {
    Integer agentId = message.getAgentId();
    if (null == agentId) {
      message.setAgentId(this.cpService.getWxCpConfigStorage().getAgentId());
    }

    return WxCpMessageSendResult.fromJson(this.cpService.post(this.cpService.getWxCpConfigStorage()
      .getApiUrl(WxCpApiPathConsts.Message.LINKEDCORP_MESSAGE_SEND), message.toJson()));
  }
}
