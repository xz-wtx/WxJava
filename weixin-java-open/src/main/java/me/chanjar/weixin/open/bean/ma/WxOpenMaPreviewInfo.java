package me.chanjar.weixin.open.bean.ma;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author zxfreedom
 * @description
 * created on  2019/12/30
 */
@Data
public class WxOpenMaPreviewInfo {

  /**
   * 录屏mediaid列表，可以通过提审素材上传接口获得
   */
  @SerializedName("video_id_list")
  private String[] videoIdList;

  /**
   * 截屏mediaid列表，可以通过提审素材上传接口获得
   */
  @SerializedName("pic_id_list")
  private String[] picIdList;
}
