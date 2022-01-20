package me.chanjar.weixin.cp.api.impl;

import lombok.RequiredArgsConstructor;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpKfService;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.WxCpBaseResp;
import me.chanjar.weixin.cp.bean.kf.WxCpKfAccountAdd;
import me.chanjar.weixin.cp.bean.kf.WxCpKfAccountAddResp;
import me.chanjar.weixin.cp.bean.kf.WxCpKfAccountDel;
import me.chanjar.weixin.cp.bean.kf.WxCpKfAccountLink;
import me.chanjar.weixin.cp.bean.kf.WxCpKfAccountLinkResp;
import me.chanjar.weixin.cp.bean.kf.WxCpKfAccountListResp;
import me.chanjar.weixin.cp.bean.kf.WxCpKfAccountUpd;
import me.chanjar.weixin.cp.util.json.WxCpGsonBuilder;

import static me.chanjar.weixin.cp.constant.WxCpApiPathConsts.Kf.*;

/**
 * 微信客服接口-服务实现
 *
 * @author Fu
 * @date 2022/1/19 19:41
 */
@RequiredArgsConstructor
public class WxCpKfServiceImpl implements WxCpKfService {
  private final WxCpService cpService;

  @Override
  public WxCpKfAccountAddResp addAccount(WxCpKfAccountAdd add) throws WxErrorException {
    String url = cpService.getWxCpConfigStorage().getApiUrl(ACCOUNT_ADD);
    String responseContent = cpService.post(url, WxCpGsonBuilder.create().toJson(add));
    return WxCpKfAccountAddResp.fromJson(responseContent);
  }

  @Override
  public WxCpBaseResp updAccount(WxCpKfAccountUpd upd) throws WxErrorException {
    String url = cpService.getWxCpConfigStorage().getApiUrl(ACCOUNT_UPD);
    String responseContent = cpService.post(url, WxCpGsonBuilder.create().toJson(upd));
    return WxCpBaseResp.fromJson(responseContent);
  }

  @Override
  public WxCpBaseResp delAccount(WxCpKfAccountDel del) throws WxErrorException {
    String url = cpService.getWxCpConfigStorage().getApiUrl(ACCOUNT_DEL);
    String responseContent = cpService.post(url, WxCpGsonBuilder.create().toJson(del));
    return WxCpBaseResp.fromJson(responseContent);
  }

  @Override
  public WxCpKfAccountListResp listAccount() throws WxErrorException {
    String url = cpService.getWxCpConfigStorage().getApiUrl(ACCOUNT_LIST);
    String responseContent = cpService.post(url, "{}");
    return WxCpKfAccountListResp.fromJson(responseContent);
  }

  @Override
  public WxCpKfAccountLinkResp getAccountLink(WxCpKfAccountLink link) throws WxErrorException {
    String url = cpService.getWxCpConfigStorage().getApiUrl(ADD_CONTACT_WAY);
    String responseContent = cpService.post(url, WxCpGsonBuilder.create().toJson(link));
    return WxCpKfAccountLinkResp.fromJson(responseContent);
  }

}
