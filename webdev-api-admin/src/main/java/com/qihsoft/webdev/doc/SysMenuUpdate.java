package com.qihsoft.webdev.doc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Qihsoft on 2017/9/8.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@ApiModel(value = "权限菜单模块")
public class SysMenuUpdate {
    @ApiModelProperty(value = "菜单名称")
    private String name;
    @ApiModelProperty(value = "对应接口函数")
    private String code;
    @ApiModelProperty(value = "图标")
    private String icon;
    @ApiModelProperty(value = "路由地址")
    private String url;
    @ApiModelProperty(value = "父级id")
    private String parentId;
    @ApiModelProperty(value = "排序方式")
    private Integer sort;
    @ApiModelProperty(value = "Id")
    private String id;

    @ApiModelProperty(value = "显示状态")
    private Integer hide;

    public Integer getHide() {
        return hide;
    }

    public void setHide(Integer hide) {
        this.hide = hide;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
