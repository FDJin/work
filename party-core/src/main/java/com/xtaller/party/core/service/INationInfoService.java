package com.xtaller.party.core.service;

import java.util.List;
import com.xtaller.party.utils.bean.Where;
import com.xtaller.party.core.model.NationInfo;

/**
* Created by Taller on 2018/08/23
*/
public interface INationInfoService {
   /******************* CURD ********************/ 
   // 创建 
   NationInfo createNationInfo(NationInfo model); 
   // 删除 
   Boolean deleteNationInfo(Object ids,String reviser);
   // 修改 
   NationInfo updateNationInfo(NationInfo model); 
   // 查询 
   List<NationInfo> findByIds(Object ids);
   // 属于 
   Boolean exist(List<Where> w); 
   // 查询一个id是否存在 
   Boolean existId(Object id); 
   /******************* CURD ********************/ 
 
}