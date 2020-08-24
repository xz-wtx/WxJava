package com.github.binarywang.wxpay.bean.ecommerce;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 合单支付 JSAPI支付结果响应
 */
@Data
@NoArgsConstructor
public class CombineTransactionsJsResult implements Serializable {

  /**
   * <pre>
   * 字段名：预支付交易会话标识
   * 变量名：prepay_id
   * 是否必填：是
   * 类型：string(64)
   * 描述：
   *  数字和字母。微信生成的预支付会话标识，用于后续接口调用使用。
   *  示例值：wx201410272009395522657a690389285100
   * </pre>
   */
  @SerializedName("prepay_id")
  private String prepayId;

}
