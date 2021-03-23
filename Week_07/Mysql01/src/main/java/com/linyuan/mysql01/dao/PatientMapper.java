package com.linyuan.mysql01.dao;

import com.linyuan.mysql01.bean.Orders;
import com.linyuan.mysql01.bean.Patient;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author dengxi
 * @Date 2021/3/7 11:03 下午
 * @desc:描述
 */
@Mapper
public interface PatientMapper {
    @Insert("insert into patient(id, store_id, mobile, name, id_no, gender, ages, patient_type, create_time) values(#{id}, #{storeId}, #{mobile}, #{name}, #{idNo}, #{gender}, #{ages}, #{patientType}, #{createTime})")
    int insert(Patient patient);
}
