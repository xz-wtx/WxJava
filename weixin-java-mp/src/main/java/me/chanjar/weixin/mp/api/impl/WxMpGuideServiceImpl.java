package me.chanjar.weixin.mp.api.impl;

import lombok.AllArgsConstructor;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.util.json.GsonHelper;
import me.chanjar.weixin.mp.api.WxMpGuideService;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.guide.WxMpGuideInfo;
import me.chanjar.weixin.mp.enums.WxMpApiUrl;

/**
 * .
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 * @date 2020-10-06
 */
@AllArgsConstructor
public class WxMpGuideServiceImpl implements WxMpGuideService {
  private static final String ACCOUNT = "guide_account";
  private static final String OPENID = "guide_openid";
  private final WxMpService mpService;

  @Override
  public void addGuide(String account, String openid, String headImgUrl, String nickName) throws WxErrorException {
    this.mpService.post(WxMpApiUrl.Guide.ADD_GUIDE, GsonHelper.buildJsonObject(ACCOUNT, account,
      "guide_headimgurl", headImgUrl, "guide_nickname", nickName, OPENID, openid));
  }

  @Override
  public void addGuide(WxMpGuideInfo guideInfo) throws WxErrorException {
    this.mpService.post(WxMpApiUrl.Guide.ADD_GUIDE,
      GsonHelper.buildJsonObject(ACCOUNT, guideInfo.getAccount(),
        "guide_headimgurl", guideInfo.getHeadImgUrl(),
        "guide_nickname", guideInfo.getNickName(),
        OPENID, guideInfo.getOpenid()));
  }

  @Override
  public WxMpGuideInfo getGuide(String account, String openid) throws WxErrorException {
    return WxMpGuideInfo.fromJson(this.mpService.post(WxMpApiUrl.Guide.GET_GUIDE,
      GsonHelper.buildJsonObject(ACCOUNT, account, OPENID, openid)));
  }
}
