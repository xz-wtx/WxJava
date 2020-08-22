package com.github.binarywang.wxpay.service;

import com.github.binarywang.wxpay.bean.ecommerce.ApplymentsRequest;
import com.github.binarywang.wxpay.bean.ecommerce.ApplymentsResult;
import com.github.binarywang.wxpay.bean.ecommerce.ApplymentsStatusResult;
import com.github.binarywang.wxpay.exception.WxPayException;

/**
 * <pre>
 *  电商收付通相关服务类.
 *  接口规则：https://wechatpay-api.gitbook.io/wechatpay-api-v3
 * </pre>
 *
 * @author cloudX
 * @date 2020/08/17
 */
public interface EcommerceService {
  /**
   * <pre>
   * 二级商户进件API
   * 接口地址: https://api.mch.weixin.qq.com/v3/ecommerce/applyments/
   * 文档地址: https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/ecommerce/applyments/chapter3_1.shtml
   *
   * </pre>
   *
   * @param request 请求对象
   * @return . applyments result
   * @throws WxPayException the wx pay exception
   */
  ApplymentsResult createApply(ApplymentsRequest request) throws WxPayException;

  /**
   * <pre>
   * 查询申请状态API
   * 请求URL: https://api.mch.weixin.qq.com/v3/ecommerce/applyments/{applyment_id}
   * 文档地址: https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/ecommerce/applyments/chapter3_2.shtml
   * </pre>
   *
   * @param applymentId 申请单ID
   * @return . applyments status result
   * @throws WxPayException the wx pay exception
   */
  ApplymentsStatusResult queryApplyStatusByApplymentId(String applymentId) throws WxPayException;

  /**
   * <pre>
   * 查询申请状态API
   * 请求URL: https://api.mch.weixin.qq.com/v3/ecommerce/applyments/out-request-no/{out_request_no}
   * 文档地址: https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/ecommerce/applyments/chapter3_2.shtml
   * </pre>
   *
   * @param outRequestNo 业务申请编号
   * @return . applyments status result
   * @throws WxPayException the wx pay exception
   */
  ApplymentsStatusResult queryApplyStatusByOutRequestNo(String outRequestNo) throws WxPayException;

}
