package com.kati.model;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TeacherMapper implements RowMapper {

    public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {

        Teacher teacher = new Teacher();
        teacher.setId(rs.getInt("id"));
        teacher.setName(rs.getString("name"));

        return teacher;

    }
}
