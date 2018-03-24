package com.kati.action;

import com.kati.model.Child;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ReadData_Action extends ActionSupport {

    private Child child;
    //private String id;
    //private String fullName;
    //private String ageMonth;

    List<Child> childrenList = new ArrayList<Child>();


    public List<Child> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(ArrayList<Child> childrenList) {
        this.childrenList = childrenList;
    }


    public String execute(){


        Connection connection = null;

        try{
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://192.168.195.131:3306/fullstackprojectdata?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            //Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");


            connection = DriverManager.getConnection(URL, "zoli", "Omeg@777");
            String sql = "SELECT * FROM Child";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();


            while(rs.next()){
                Child child = new Child();
                child.setId(rs.getInt(1));
                child.setFullName(rs.getString(2));
                child.setAgeMonth(rs.getInt(3));
                childrenList.add(child);
            }

            connection.close();
        }catch(Exception e){e.printStackTrace();}

        return "success";
    }
}
