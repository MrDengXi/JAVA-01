package com.linyuan.dao;

import com.linyuan.bean.Student;

/**
 * @Author dengxi
 * @Date 2021/2/20 2:49 下午
 * @desc:描述
 */
public interface StudentDao {
    /**
     * 新增
     * @param student
     * @return
     */
    int insert(Student student);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 修改
     * @param student
     * @return
     */
    int updateById(Student student);

    /**
     * 查询
     * @param id
     * @return
     */
    Student findById(int id);
}
