package com.kati.model;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ChildMapper implements RowMapper{

    public Child mapRow(ResultSet rs, int rowNum) throws SQLException {

        Child child = new Child();
        child.setId(rs.getInt("id"));
        child.setFullName(rs.getString("fullName"));
        child.setAgeMonth(rs.getInt("ageMonth"));

        return child;
    }


}
