package com.linyuan.dao;

import com.linyuan.bean.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author DengXi
 * @Date 2021/2/20 2:54 下午
 * @desc:描述
 */
public class JdbcTemplateStudentDao implements StudentDao {

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate = null;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int insert(Student student) {
        String sql = "insert into student(id, name, age) values(?, ?, ?)";
        jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.update(sql, student.getId(), student.getName(), student.getAge());
    }

    @Override
    public int deleteById(int id) {
        String sql = "delete from student where id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateById(Student student) {
        String sql = "update student set name = ?, age = ? where id = ?";
        return jdbcTemplate.update(sql, student.getName(), student.getAge(), student.getId());
    }

    @Override
    public Student findById(int id) {
        String sql = "select * from student where id = ?";
        List<Student> list = (List<Student>) jdbcTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Student(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("age"));
            }
        }, id);
        if (list != null && list.size() != 0) {
            return list.get(0);
        }
        return null;
    }
}
