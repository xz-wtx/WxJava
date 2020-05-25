package com.binarywang.spring.starter.wxjava.miniapp.properties;

import com.binarywang.spring.starter.wxjava.miniapp.enums.HttpClientType;
import com.binarywang.spring.starter.wxjava.miniapp.enums.StorageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 存储策略.
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 * @date 2020-05-25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ConfigStorage implements Serializable {
  private static final long serialVersionUID = 4815731027000065434L;

  /**
   * 存储类型.
   */
  private StorageType type = StorageType.Memory;

  /**
   * 指定key前缀.
   */
  private String keyPrefix = "wa";

  /**
   * redis连接配置.
   */
  private RedisProperties redis;

  /**
   * http客户端类型.
   */
  private HttpClientType httpClientType = HttpClientType.HttpClient;

  /**
   * http代理主机.
   */
  private String httpProxyHost;

  /**
   * http代理端口.
   */
  private Integer httpProxyPort;

  /**
   * http代理用户名.
   */
  private String httpProxyUsername;

  /**
   * http代理密码.
   */
  private String httpProxyPassword;

}
