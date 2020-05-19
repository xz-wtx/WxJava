package com.github.binarywang.wxpay.service.impl;

import com.github.binarywang.wxpay.bean.payscore.WxPayScoreRequest;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.testbase.ApiTestModule;
import com.google.inject.Inject;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

/**
 * 测试代码，待补充完善.
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 * @date 2020-05-19
 */
@Test
@Guice(modules = ApiTestModule.class)
public class PayScoreServiceImplTest {
  @Inject
  private WxPayService payService;

  @Test
  public void testCreateServiceOrder() throws WxPayException {
    this.payService.getPayScoreService().createServiceOrder(WxPayScoreRequest.builder().build());
  }

  @Test
  public void testQueryServiceOrder() {
  }

  @Test
  public void testCancelServiceOrder() {
  }

  @Test
  public void testModifyServiceOrder() {
  }

  @Test
  public void testCompleteServiceOrder() {
  }

  @Test
  public void testPayServiceOrder() {
  }

  @Test
  public void testSyncServiceOrder() {
  }

  @Test
  public void testDecryptNotifyData() {
  }
}
