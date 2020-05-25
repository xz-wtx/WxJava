package com.binarywang.spring.starter.wxjava.miniapp.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * redis配置.
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 * @date 2020-05-25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RedisProperties implements Serializable {
  private static final long serialVersionUID = -5924815351660074401L;

  /**
   * 主机地址.
   */
  private String host;

  /**
   * 端口号.
   */
  private int port = 6379;

  /**
   * 密码.
   */
  private String password;

  /**
   * 超时.
   */
  private int timeout = 2000;

  /**
   * 数据库.
   */
  private int database = 0;

  private Integer maxActive;
  private Integer maxIdle;
  private Integer maxWaitMillis;
  private Integer minIdle;
}
