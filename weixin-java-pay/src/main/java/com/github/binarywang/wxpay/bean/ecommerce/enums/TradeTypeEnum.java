package com.github.binarywang.wxpay.bean.ecommerce.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 支付方式
 */
@Getter
@AllArgsConstructor
public enum TradeTypeEnum {

  APP("/v3/combine-transactions/app","/v3/pay/partner/transactions/app"),
  JSAPI("/v3/combine-transactions/jsapi","/v3/pay/partner/transactions/jsapi"),
  NATIVE("/v3/combine-transactions/native","/v3/pay/partner/transactions/native"),
  H5("/v3/combine-transactions/h5","/v3/pay/partner/transactions/h5")
  ;

  /**
   * 合单url
   */
  private String combineUrl;
  /**
   * 单独下单url
   */
  private String partnerUrl;
}
