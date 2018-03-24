package com.kati.action;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginAction extends ActionSupport{

    private String id;
    private String fullName;
    private String ageMonth;

    public String execute() {

        String ret = ERROR;
        Connection conn = null;

        try {
            String URL = "jdbc:mysql://localhost:3306/fullstackprojectdata";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, "childcareuser", "childcareuser");
            String sql = "SELECT name FROM login WHERE id = ? AND fullName = ? AND ageMonth = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, fullName);
            ps.setString(3, ageMonth);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getString(1);
                ret = SUCCESS;
            }
        } catch (Exception e) {
            ret = ERROR;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }
        return ret;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAgeMonth() {
        return ageMonth;
    }

    public void setAgeMonth(String ageMonth) {
        this.ageMonth = ageMonth;
    }
}
