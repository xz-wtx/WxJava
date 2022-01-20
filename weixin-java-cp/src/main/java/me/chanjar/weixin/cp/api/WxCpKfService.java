package me.chanjar.weixin.cp.api;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.cp.bean.WxCpBaseResp;
import me.chanjar.weixin.cp.bean.kf.WxCpKfAccountAdd;
import me.chanjar.weixin.cp.bean.kf.WxCpKfAccountAddResp;
import me.chanjar.weixin.cp.bean.kf.WxCpKfAccountDel;
import me.chanjar.weixin.cp.bean.kf.WxCpKfAccountLink;
import me.chanjar.weixin.cp.bean.kf.WxCpKfAccountLinkResp;
import me.chanjar.weixin.cp.bean.kf.WxCpKfAccountListResp;
import me.chanjar.weixin.cp.bean.kf.WxCpKfAccountUpd;

/**
 * 微信客服接口
 *
 *  微信客服由腾讯微信团队为企业打造，用于满足企业的客服需求，帮助企业做好客户服务。企业可以在微信内、外各个场景中接入微信客服，
 *  用户可以发起咨询，企业可以进行回复。
 *  企业可在微信客服官网使用企业微信扫码开通微信客服，开通后即可使用。
 *
 * @author Fu
 * @date 2022/1/19 19:25
 */
public interface WxCpKfService {

  /**
   * 添加客服帐号，并可设置客服名称和头像。目前一家企业最多可添加10个客服帐号
   *
   * @param add 客服帐号信息
   * @return result-新创建的客服帐号ID
   * @throws WxErrorException 异常
   */
  WxCpKfAccountAddResp addAccount(WxCpKfAccountAdd add) throws WxErrorException;

  /**
   * 修改已有的客服帐号，可修改客服名称和头像。
   *
   * @param upd 新的客服账号信息
   * @return result
   * @throws WxErrorException 异常
   */
  WxCpBaseResp updAccount(WxCpKfAccountUpd upd) throws WxErrorException;

  /**
   * 删除已有的客服帐号
   *
   * @param del 要删除的客服帐号
   * @return result
   * @throws WxErrorException 异常
   */
  WxCpBaseResp delAccount(WxCpKfAccountDel del) throws WxErrorException;

  /**
   * 获取客服帐号列表，包括所有的客服帐号的客服ID、名称和头像。
   *
   * @return 客服帐号列表
   * @throws WxErrorException 异常
   */
  WxCpKfAccountListResp listAccount() throws WxErrorException;

  /**
   * 企业可通过此接口获取带有不同参数的客服链接，不同客服帐号对应不同的客服链接。获取后，企业可将链接嵌入到网页等场景中，
   * 微信用户点击链接即可向对应的客服帐号发起咨询。企业可依据参数来识别用户的咨询来源等
   *
   * @param link 参数
   * @return 链接
   * @throws WxErrorException 异常
   */
  WxCpKfAccountLinkResp getAccountLink(WxCpKfAccountLink link) throws WxErrorException;

}
