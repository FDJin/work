package com.qihsoft.webdev.core.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.qihsoft.webdev.utils.kit.IdKit;


import java.io.Serializable;

/**
* Created by Qihsoft on 2017/10/09
*/
@SuppressWarnings("serial")
@TableName(value = "sys_global_config")
public class SysGlobalConfig extends Model<SysGlobalConfig> {
  private String id = IdKit.getId(this.getClass());
  private String systemId;
  private String attr;
  private String val;
  private String creator;
  private Integer createTime;
  private String reviser;
  private Integer reviseTime;
  private Integer isDel;

  public String getId() { 
      return id;
  } 
  public void setId(String id) { 
      this.id = id;
  } 
  public String getSystemId() { 
      return systemId;
  } 
  public void setSystemId(String systemId) { 
      this.systemId = systemId;
  } 
  public String getAttr() { 
      return attr;
  } 
  public void setAttr(String attr) { 
      this.attr = attr;
  } 
  public String getVal() { 
      return val;
  } 
  public void setVal(String val) { 
      this.val = val;
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
  @Override
  protected Serializable pkVal() {
      return id;
  }
}
