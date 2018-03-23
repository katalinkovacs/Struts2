package com.kati.action;

import com.kati.dataobject.Child;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ReadData_Action extends ActionSupport {

    private Child child;
    //private String id;
    //private String fullName;
    //private String ageMonth;

    ArrayList<Child> childrenList = new ArrayList<Child>();


    public ArrayList<Child> getList() {
        return childrenList;
    }

    public void setList(ArrayList<Child> childrenList) {
        this.childrenList = childrenList;
    }


    public String execute(){

        String ret = ERROR;
        Connection connection = null;

        try{
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/fullstackproject";
            //Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");


            connection = DriverManager.getConnection(URL, "childcareuser", "childcareuser");
            String sql = "SELECT * FROM child WHERE fullName = \"Sebi\"";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, child.getId());
            ps.setString(2, child.getAgeMonth());
            ps.setString(3, child.getFullName());
            ResultSet rs = ps.executeQuery();


            while(rs.next()){
                Child child = new Child();
                child.setId(rs.getInt(1));
                child.setFullName(rs.getString(2));
                child.setAgeMonth(rs.getString(3));
                childrenList.add(child);
            }

            connection.close();
        }catch(Exception e){e.printStackTrace();}

        return "success";
    }
}
