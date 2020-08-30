package me.chanjar.weixin.cp.api;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.cp.bean.message.WxCpLinkedCorpMessage;
import me.chanjar.weixin.cp.bean.message.WxCpMessage;
import me.chanjar.weixin.cp.bean.message.WxCpMessageSendResult;

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
   * 详情请见: https://work.weixin.qq.com/api/doc/90000/90135/90236
   * </pre>
   *
   * @param message 要发送的消息对象
   * @return the wx cp message send result
   * @throws WxErrorException the wx error exception
   */
  WxCpMessageSendResult send(WxCpMessage message) throws WxErrorException;

  /**
   * <pre>
   * 互联企业的应用支持推送文本、图片、视频、文件、图文等类型。
   *
   * 请求地址：https://qyapi.weixin.qq.com/cgi-bin/linkedcorp/message/send?access_token=ACCESS_TOKEN
   * 文章地址：https://work.weixin.qq.com/api/doc/90000/90135/90250
   * </pre>
   *
   * @param message 要发送的消息对象
   * @return the wx cp message send result
   * @throws WxErrorException the wx error exception
   */
  WxCpMessageSendResult sendLinkedCorpMessage(WxCpLinkedCorpMessage message) throws WxErrorException;
}
