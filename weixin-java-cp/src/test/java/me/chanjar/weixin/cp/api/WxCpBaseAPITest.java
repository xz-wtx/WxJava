package me.chanjar.weixin.cp.api;

import com.google.inject.Inject;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.cp.api.impl.WxCpServiceImpl;
import me.chanjar.weixin.cp.config.WxCpConfigStorage;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

/**
 * 基础API测试
 *
 * @author Daniel Qian
 */
@Test(groups = "baseAPI")
@Guice(modules = ApiTestModule.class)
public class WxCpBaseAPITest {

  /**
   * The Wx service.
   */
  @Inject
  protected WxCpServiceImpl wxService;

  /**
   * Test refresh access token.
   *
   * @throws WxErrorException the wx error exception
   */
  public void testRefreshAccessToken() throws WxErrorException {
    WxCpConfigStorage configStorage = this.wxService.getWxCpConfigStorage();
    String before = configStorage.getAccessToken();
    this.wxService.getAccessToken(false);

    String after = configStorage.getAccessToken();

    Assert.assertNotEquals(before, after);
    Assert.assertTrue(StringUtils.isNotBlank(after));
  }

}
