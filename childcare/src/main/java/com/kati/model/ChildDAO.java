package com.kati.model;

import java.util.List;

//import javax.sql.DataSource;

public interface ChildDAO {

    //public void setDataSource(DataSource ds);

    // METHOD to INSERT a record in the Child table.
    //public void insertRecord(int id, String fullName, int ageMonth);  --> NOT A GOOD PRACTISE

    public void insertRecord(Child child);

    // METHOD to LIST a record from the Child table by id.
    public Child findChildById(int id);

    public Child findChildByName(String fullName);

    // METHOD to LIST all records from the Child table.
    public List<Child> listAllChildren();

    // METHOD to DELETE a record from the Child table.
    public void deleteRecord(int id);

    // METHOD to UPDATE a record in the Child table.
    public void updateRecord(int id, int ageMonth);

}
