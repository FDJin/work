package com.qihsoft.webdev.core.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.qihsoft.webdev.utils.kit.IdKit;

import java.io.Serializable;

/**
 * Created by Taller on 2018/11/10
 */
@SuppressWarnings("serial")
@TableName(value = "picture")
public class Picture extends Model<Picture> {
  private String id = IdKit.getId(this.getClass());
  private String name;
  private String artworkURL;
  private String thumbnailURL;
  private String path;
  private String describe;
  private String code;
  private String creator;
  private Integer createTime;
  private String reviser;
  private Integer reviseTime;
  private Integer isDel;
  private String tableId;

  public String getId() { 
      return id;
  } 
  public void setId(String id) { 
      this.id = id;
  } 
  public String getName() { 
      return name;
  } 
  public void setName(String name) { 
      this.name = name;
  } 
  public String getArtworkURL() { 
      return artworkURL;
  } 
  public void setArtworkURL(String artworkURL) { 
      this.artworkURL = artworkURL;
  } 
  public String getThumbnailURL() { 
      return thumbnailURL;
  } 
  public void setThumbnailURL(String thumbnailURL) { 
      this.thumbnailURL = thumbnailURL;
  } 
  public String getPath() { 
      return path;
  } 
  public void setPath(String path) { 
      this.path = path;
  } 
  public String getDescribe() { 
      return describe;
  } 
  public void setDescribe(String describe) { 
      this.describe = describe;
  } 
  public String getCode() { 
      return code;
  } 
  public void setCode(String code) { 
      this.code = code;
  } 
  public String getCreator() { 
      return creator;
  } 
  public void setCreator(String creator) { 
      this.creator = creator;
  } 
  public Integer getCreateTime() { 
      return createTime;
  } 
  public void setCreateTime(Integer createTime) { 
      this.createTime = createTime;
  } 
  public String getReviser() { 
      return reviser;
  } 
  public void setReviser(String reviser) { 
      this.reviser = reviser;
  } 
  public Integer getReviseTime() { 
      return reviseTime;
  } 
  public void setReviseTime(Integer reviseTime) { 
      this.reviseTime = reviseTime;
  } 
  public Integer getIsDel() { 
      return isDel;
  } 
  public void setIsDel(Integer isDel) { 
      this.isDel = isDel;
  } 
  public String getTableId() { 
      return tableId;
  } 
  public void setTableId(String tableId) { 
      this.tableId = tableId;
  } 
  @Override
  protected Serializable pkVal() {
      return id;
  }
}
