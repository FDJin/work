package com.qihsoft.webdev.core.service.impl;

import com.qihsoft.webdev.core.service.ISysUserRoleService;
import com.qihsoft.webdev.core.model.SysRole;
import com.qihsoft.webdev.core.model.SysUserRole;
import com.qihsoft.webdev.utils.base.TServiceImpl;
import com.qihsoft.webdev.utils.bean.Where;
import com.qihsoft.webdev.utils.convert.V;
import com.qihsoft.webdev.utils.convert.W;
import com.qihsoft.webdev.utils.kit.IdKit;
import com.qihsoft.webdev.core.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* Created by Qihsoft on 2017/09/25
*/
@Service
public class SysUserRoleService extends TServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {
    @Autowired
    private SysRoleService roleService;

    /**************************CURD begin******************************/
   // 创建
   @Override
   public SysUserRole createUserRole(SysUserRole model) {
       if(this.insert(model))
           return this.selectById(model.getId());
       return null;
   }
 
   // 删除
   @Override
   public Boolean deleteUserRole(Object ids,String reviser) {
       return this.delete(ids,reviser);
   }
 
   // 修改
   @Override
   public SysUserRole updateUserRole(SysUserRole model) {
       if(this.update(model))
           return this.selectById(model.getId());
       return null;
   }
 
   // 查询
   @Override
   public List<SysUserRole> findByIds(Object ids) {
       return this.selectByIds(ids);
   }
 
   // 属于
   @Override
   public Boolean exist(List<Where> w) {
       w.add(new Where("1"));
       return this.query(w).size() > 0;
   }
 
   // 查询一个id是否存在
   @Override
   public Boolean existId(Object id) {
       where = W.f(
               W.and("id","eq",id),
               W.field("1")
       );
       return this.query(where).size() > 0;
   }

    @Override
    public SysUserRole findByUserId(String userId) {
        where = W.f(
                W.and("userId","eq",userId)
        );
        List<SysUserRole> urs = this.query(where);
        return urs.size() > 0 ? urs.get(0) : null;
    }

    /**************************CURD end********************************/

    @Override
    public Boolean deleteByUserIdAndSystemId(String userId) {
        return baseMapper.deleteByUserIdAndSystemId(userId);
    }

    @Transactional
    @Override
    public Boolean setUserRole(String userId,List<SysUserRole> models) {
        deleteByUserIdAndSystemId(userId);

        if(models.size() >0){
//            String systemIds = L.getAttrs(models,"systemId");
//            where = W.f(
//                    W.and("systemId","in",systemIds),
//                    W.and("isDefault","eq",1)
//            );
//            List<Role> roles = roleService.query(where);
            for(SysUserRole ur:models){
                ur.setId(IdKit.getId(SysUserRole.class));
//                ur.setRoleId(getRoleIdBySystemId(ur.getSystemId(),roles));
                this.insert(ur);
            }
        }
        return true;
    }

    @Override
    public Boolean initSystem(String systemId, String userId) {
        where = W.f(
                W.and("systemId","eq",systemId),
                W.and("isDefault","eq",1)
        );
        List<SysRole> sysRoles = roleService.query(where);
        if(sysRoles.size() == 0)
            return false;
        SysUserRole ur = new SysUserRole();
        ur.setCreator(userId);
        ur.setSystemId(systemId);
        ur.setUserId(userId);
        ur.setRoleId(sysRoles.get(0).getId());
        this.insert(ur);
        return true;
    }

    private String getRoleIdBySystemId(String systemId,List<SysRole> sysRoles){
        String roleId = "";
        for(SysRole sysRole : sysRoles){
            if (V.isEqual(sysRole.getSystemId(),systemId)){
                roleId = sysRole.getId();
                break;
            }
        }
        return roleId;
    }
}