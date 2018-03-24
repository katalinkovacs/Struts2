package com.kati.action;

import com.kati.dataobject.Child;
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


    private List<String> comboMeals;

    public List<String> getComboMeals() {
        return comboMeals;
    }

    public void setComboMeals(List<String> comboMeals) {
        this.comboMeals = comboMeals;
    }



    public List<Child> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(ArrayList<Child> childrenList) {
        this.childrenList = childrenList;
    }


    public String execute(){


        comboMeals = new ArrayList<String>();
        comboMeals.add("Snack Plate");
        comboMeals.add("Dinner Plate");
        comboMeals.add("Colonel Chicken Rice Combo");
        comboMeals.add("Colonel Burger");
        comboMeals.add("O.R. Fillet Burger");
        comboMeals.add("Zinger Burger");


        Connection connection = null;

        try{
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://192.168.195.129:3306/fullstackprojectdata";
            //Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");


            connection = DriverManager.getConnection(URL, "zoli", "Omeg@777");
            String sql = "SELECT * FROM Child";

            PreparedStatement ps = connection.prepareStatement(sql);
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

        return SUCCESS;
    }
}
