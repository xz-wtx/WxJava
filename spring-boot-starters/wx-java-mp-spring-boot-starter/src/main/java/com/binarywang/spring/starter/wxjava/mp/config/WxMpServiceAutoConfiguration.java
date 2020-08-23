package com.binarywang.spring.starter.wxjava.mp.config;

import com.binarywang.spring.starter.wxjava.mp.properties.WxMpProperties;
import me.chanjar.weixin.common.api.WxOcrService;
import me.chanjar.weixin.mp.api.*;
import me.chanjar.weixin.mp.api.impl.WxMpServiceHttpClientImpl;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.api.impl.WxMpServiceJoddHttpImpl;
import me.chanjar.weixin.mp.api.impl.WxMpServiceOkHttpImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 微信公众号相关服务自动注册.
 *
 * @author someone
 */
@Configuration
public class WxMpServiceAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public WxMpService wxMpService(WxMpConfigStorage configStorage, WxMpProperties wxMpProperties) {
    WxMpProperties.HttpClientType httpClientType = wxMpProperties.getConfigStorage().getHttpClientType();
    WxMpService wxMpService;
    if (httpClientType == WxMpProperties.HttpClientType.okhttp) {
      wxMpService = newWxMpServiceOkHttpImpl();
    } else if (httpClientType == WxMpProperties.HttpClientType.joddhttp) {
      wxMpService = newWxMpServiceJoddHttpImpl();
    } else if (httpClientType == WxMpProperties.HttpClientType.httpclient) {
      wxMpService = newWxMpServiceHttpClientImpl();
    } else {
      wxMpService = newWxMpServiceImpl();
    }

    wxMpService.setWxMpConfigStorage(configStorage);
    return wxMpService;
  }

  private WxMpService newWxMpServiceImpl() {
    return new WxMpServiceImpl();
  }

  private WxMpService newWxMpServiceHttpClientImpl() {
    return new WxMpServiceHttpClientImpl();
  }

  private WxMpService newWxMpServiceOkHttpImpl() {
    return new WxMpServiceOkHttpImpl();
  }

  private WxMpService newWxMpServiceJoddHttpImpl() {
    return new WxMpServiceJoddHttpImpl();
  }

}
