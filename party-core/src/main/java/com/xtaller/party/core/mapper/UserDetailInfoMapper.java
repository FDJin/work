package com.xtaller.party.core.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.xtaller.party.core.model.UserDetailInfo;

import java.util.List;
/**
 * Created by party on 2018/08/10
 */
public interface UserDetailInfoMapper extends BaseMapper<UserDetailInfo> {

    @Select("SELECT a.* FROM v_user_info a " +
            "JOIN (SELECT id from v_user_info where isDel = 0 ${where} " +
            "LIMIT #{index}, #{size})b ON a.id=b.id order by a.createTime asc ") 
    List<JSONObject> getPage(@Param("where") String where, 
                             @Param("index") int index, 
                             @Param("size") int size); 

    @Select("select count(1) total from v_user_info where isDel = 0 ${where} ")
    JSONObject getPageCount(@Param("where") String where); 

    @Select("SELECT a.* FROM v_user_info a where 1=1 and isDel=0 ${where}  order by createTime desc")
    List<JSONObject> queryAll(@Param("where") String where);

    @Select("SELECT a.* FROM v_user_info a " +
            "where 1=1  ${where}  " +
            "order by a.createTime desc ")
    List<JSONObject> queryMembers(@Param("where") String where);
}