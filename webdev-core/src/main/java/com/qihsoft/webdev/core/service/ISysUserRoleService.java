package com.qihsoft.webdev.core.service;

import com.qihsoft.webdev.core.model.SysUserRole;
import com.qihsoft.webdev.utils.bean.Where;

import java.util.List;

/**
* Created by Qihsoft on 2017/09/25
*/
public interface ISysUserRoleService {
   /******************* CURD ********************/ 
   // 创建
   SysUserRole createUserRole(SysUserRole model);
   // 删除
   Boolean deleteUserRole(Object ids, String reviser);
   // 修改
   SysUserRole updateUserRole(SysUserRole model);
   // 查询
   List<SysUserRole> findByIds(Object ids);
   // 属于
   Boolean exist(List<Where> w);
   // 查询一个id是否存在
   Boolean existId(Object id);
   /******************* CURD ********************/
   //判断用户是否开通了子系统
   SysUserRole findByUserId(String userId);
   Boolean deleteByUserIdAndSystemId(String userId);
   Boolean setUserRole(String userId, List<SysUserRole> models);
   Boolean initSystem(String systemId, String userId);
}