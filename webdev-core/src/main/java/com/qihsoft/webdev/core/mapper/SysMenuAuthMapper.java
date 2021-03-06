package com.qihsoft.webdev.core.mapper;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qihsoft.webdev.core.model.SysMenuAuth;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* Created by Qihsoft on 2017/09/18
*/
public interface SysMenuAuthMapper extends BaseMapper<SysMenuAuth> {
    //查询目录
    @Select("SELECT id,name,menuId parentId FROM sys_menu_auth  where 1=1 and isDel=0 ${where}  order by createTime asc")
    List<JSONObject> queryList(@Param("where") String where);

    //查询权限列表
    @Select("SELECT * FROM sys_menu_auth where 1=1 and isDel=0 and id in ( select authId FROM sys_role_auth where isDel =0 and roleId = ${roleId} )  order by createTime asc")
    List<JSONObject> queryAuths(@Param("roleId") String roleId);
}