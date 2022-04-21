package me.chanjar.weixin.open.bean.auth;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="https://github.com/007gzs">007</a>
 */
@Data
public class WxOpenAuthorizerInfo implements Serializable {
  private static final long serialVersionUID = -5327886953416394738L;

  private String nickName;
  private String headImg;
  private Integer serviceTypeInfo;
  private Integer verifyTypeInfo;
  private String userName;
  private String principalName;
  private Map<String, Integer> businessInfo;
  private String alias;
  private String qrcodeUrl;
  /**
   * 帐号状态
   * 类型	说明
   * 1	正常
   * 14	已注销
   * 16	已封禁
   * 18	已告警
   * 19	已冻结
   */
  private Integer accountStatus;
  /**
   * 账号介绍
   */
  private String signature;

  /**
   * 可根据这个字段判断是否为小程序类型授权
   */
  private MiniProgramInfo miniProgramInfo;

  @Data
  public static class MiniProgramInfo implements Serializable {
    private static final long serialVersionUID = 8857028017332191988L;
    @SerializedName("visit_status")
    private Integer visitStatus;
    /**
     * 小程序已设置的各个服务器域名.
     */
    private Network network;
    private List<Category> categories;

    @Data
    public static class Category implements Serializable {
      private static final long serialVersionUID = -5771529867281696141L;
      private String first;
      private String second;
    }

    @Data
    public static class Network implements Serializable {
      private static final long serialVersionUID = -18932624803859857L;
      @SerializedName("RequestDomain")
      private List<String> requestDomain;
      @SerializedName("WsRequestDomain")
      private List<String> wsRequestDomain;
      @SerializedName("UploadDomain")
      private List<String> uploadDomain;
      @SerializedName("DownloadDomain")
      private List<String> downloadDomain;
      @SerializedName("BizDomain")
      private List<String> bizDomain;
    }
  }
}
