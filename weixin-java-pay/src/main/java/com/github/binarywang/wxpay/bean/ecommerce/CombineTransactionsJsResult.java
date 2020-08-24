package com.github.binarywang.wxpay.bean.ecommerce;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CombineTransactionsJsResult implements Serializable {

  @SerializedName("prepay_id")
  private String prepayId;

}
