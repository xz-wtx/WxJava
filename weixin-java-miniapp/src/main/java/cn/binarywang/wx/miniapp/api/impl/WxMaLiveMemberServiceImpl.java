package cn.binarywang.wx.miniapp.api.impl;

import cn.binarywang.wx.miniapp.api.WxMaLiveMemberService;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.constant.WxMaApiUrlConstants.Broadcast.Role;
import com.google.gson.JsonArray;
import lombok.RequiredArgsConstructor;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.util.json.GsonHelper;
import me.chanjar.weixin.common.util.json.GsonParser;

import static cn.binarywang.wx.miniapp.constant.WxMaApiUrlConstants.Broadcast.Role.LIST_BY_ROLE;

/**
 * .
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 * @date 2021-02-15
 */
@RequiredArgsConstructor
public class WxMaLiveMemberServiceImpl implements WxMaLiveMemberService {
  private final WxMaService service;

  @Override
  public String addRole(String username, int role) throws WxErrorException {
    return this.service.post(Role.ADD_ROLE,
      GsonHelper.buildJsonObject("username", username, "role", role));
  }

  @Override
  public String deleteRole(String username, int role) throws WxErrorException {
    return this.service.post(Role.DELETE_ROLE,
      GsonHelper.buildJsonObject("username", username, "role", role));
  }

  @Override
  public JsonArray listByRole(Integer role, Integer offset, Integer limit, String keyword) throws WxErrorException {
    final String response = this.service.get(LIST_BY_ROLE, GsonHelper.buildJsonObject("role", role, "offset", offset,
      "limit", limit, "keyword", keyword).toString());
    return GsonParser.parse(response).getAsJsonArray("list");
  }
}
