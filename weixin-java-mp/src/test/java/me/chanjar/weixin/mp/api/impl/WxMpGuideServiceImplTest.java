package me.chanjar.weixin.mp.api.impl;

import com.google.inject.Inject;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.test.ApiTestModule;
import me.chanjar.weixin.mp.bean.guide.WxMpGuideInfo;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 单元测试.
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 * @date 2020-10-06
 */
@Guice(modules = ApiTestModule.class)
public class WxMpGuideServiceImplTest {
  @Inject
  protected WxMpService wxService;

  @Test
  public void testAddGuide() throws WxErrorException {
    this.wxService.getGuideService().addGuide("abc", "", null, null);
  }

  @Test
  public void testAddGuide_another() throws WxErrorException {
    this.wxService.getGuideService().addGuide(WxMpGuideInfo.builder().account("cde").build());
  }

  @Test
  public void testGetGuide() throws WxErrorException {
    final WxMpGuideInfo guideInfo = this.wxService.getGuideService().getGuide("abc", null);
    assertThat(guideInfo).isNotNull();
  }
}
