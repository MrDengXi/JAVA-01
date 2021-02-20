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
 * @Date 2021/2/20 3:58 下午
 * @desc:描述
 */
public class JdbcPreparedStatementDao implements StudentDao {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private Connection conn = null;
    private PreparedStatement ps = null;

    public void getConn() throws SQLException {
        conn = dataSource.getConnection();
        conn.setAutoCommit(false);
    }

    public void closeConn() throws SQLException {
        ps.close();
        conn.close();
    }

    @Override
    public int insert(Student student) {
        String sql = "insert into student(id, name, age) values(?, ?, ?)";
        try {
            getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            int resultNum = ps.executeUpdate();
            conn.commit();
            return resultNum;
        } catch (SQLException e) {
            try {
                closeConn();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return 0;
        }
    }

    @Override
    public int deleteById(int id) {
        String sql = "delete from student where id = ?";
        try {
            getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int resultNum = ps.executeUpdate();
            conn.commit();
            return resultNum;
        } catch (SQLException e) {
            try {
                closeConn();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return 0;
        }
    }

    @Override
    public int updateById(Student student) {
        String sql = "update student set name = ?, age = ? where id = ?";
        try {
            getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setInt(3, student.getId());
            int resultNum = ps.executeUpdate();
            conn.commit();
            return resultNum;
        } catch (SQLException e) {
            try {
                closeConn();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return 0;
        }
    }

    @Override
    public Student findById(int id) {
        String sql = "select * from student where id = ?";
        Student student = null;
        try {
            getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                student = new Student(result.getInt("id"), result.getString("name"), result.getInt("age"));
            }
            conn.commit();
            return student;
        } catch (SQLException e) {
            try {
                closeConn();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return student;
        }
    }
}
