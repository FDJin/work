package com.xtaller.party.core.service;

import java.util.List;
import com.xtaller.party.utils.bean.Where;
import com.xtaller.party.core.model.Exam;

/**
* Created by Taller on 2018/08/29
*/
public interface IExamService {
   /******************* CURD ********************/ 
   // 创建 
   Exam createExam(Exam model); 
   // 删除 
   Boolean deleteExam(Object ids,String reviser);
   // 修改 
   Exam updateExam(Exam model); 
   // 查询 
   List<Exam> findByIds(Object ids);
   // 属于 
   Boolean exist(List<Where> w); 
   // 查询一个id是否存在 
   Boolean existId(Object id); 
   /******************* CURD ********************/ 
 
}