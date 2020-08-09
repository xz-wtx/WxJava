package me.chanjar.weixin.mp.api.impl;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.test.ApiTestModule;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 测试类.
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 * @date 2020-08-09
 */
@Test
@Guice(modules = ApiTestModule.class)
public class WxOAuth2ServiceImplTest {
  @Inject
  private WxMpService mpService;

  @Test
  public void testBuildAuthorizationUrl() {
    final String url = this.mpService.getOAuth2Service().buildAuthorizationUrl("http://www.baidu.com", "test", "GOD");
    assertThat(url).isEqualTo("https://open.weixin.qq.com/connect/oauth2/authorize?appid=" +
      this.mpService.getWxMpConfigStorage().getAppId() +
      "&redirect_uri=http%3A%2F%2Fwww.baidu.com&response_type=code&scope=test&state=GOD&connect_redirect=1#wechat_redirect");
  }

  @Test
  public void testGetAccessToken() {
  }

  @Test
  public void testRefreshAccessToken() {
  }

  @Test
  public void testGetUserInfo() {
  }

  @Test
  public void testValidateAccessToken() {
  }
}
