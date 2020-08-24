package com.github.binarywang.wxpay.service.impl;

import com.github.binarywang.wxpay.bean.ecommerce.ApplymentsRequest;
import com.github.binarywang.wxpay.bean.ecommerce.ApplymentsResult;
import com.github.binarywang.wxpay.bean.ecommerce.ApplymentsStatusResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.EcommerceService;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.v3.util.RsaCryptoUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;

import java.net.URI;

@RequiredArgsConstructor
public class EcommerceServiceImpl implements EcommerceService {
  private static final Gson GSON = new GsonBuilder().create();
  private final WxPayService payService;

  @Override
  public ApplymentsResult createApply(ApplymentsRequest request) throws WxPayException {
    String url = String.format("%s/v3/ecommerce/applyments/", this.payService.getPayBaseUrl());
    RsaCryptoUtil.encryptFields(request, this.payService.getConfig().getVerifier().getValidCertificate());

    String result = this.payService.postV3WithWechatpaySerial(url, GSON.toJson(request));
    return GSON.fromJson(result, ApplymentsResult.class);
  }

  @Override
  public ApplymentsStatusResult queryApplyStatusByApplymentId(String applymentId) throws WxPayException {
    String url = String.format("%s/v3/ecommerce/applyments/%s", this.payService.getPayBaseUrl(), applymentId);
    String result = this.payService.getV3(URI.create(url));
    return GSON.fromJson(result, ApplymentsStatusResult.class);
  }

  @Override
  public ApplymentsStatusResult queryApplyStatusByOutRequestNo(String outRequestNo) throws WxPayException {
    String url = String.format("%s/v3/ecommerce/applyments/out-request-no/%s", this.payService.getPayBaseUrl(), outRequestNo);
    String result = this.payService.getV3(URI.create(url));
    return GSON.fromJson(result, ApplymentsStatusResult.class);
  }


}
