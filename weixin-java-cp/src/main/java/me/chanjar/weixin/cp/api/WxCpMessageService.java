package me.chanjar.weixin.cp.api;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.cp.bean.WxCpMessage;
import me.chanjar.weixin.cp.bean.WxCpMessageSendResult;

/**
 * 消息推送接口.
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 * @date 2020 -08-30
 */
public interface WxCpMessageService {
  /**
   * <pre>
   * 发送消息
   * 详情请见: http://qydev.weixin.qq.com/wiki/index.php?title=%E5%8F%91%E9%80%81%E6%8E%A5%E5%8F%A3%E8%AF%B4%E6%98%8E
   * </pre>
   *
   * @param message 要发送的消息对象
   * @return the wx cp message send result
   * @throws WxErrorException the wx error exception
   */
  WxCpMessageSendResult messageSend(WxCpMessage message) throws WxErrorException;
}
