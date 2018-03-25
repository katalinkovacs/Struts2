package com.kati.model;

import java.util.List;


public interface TeacherDao {


    //public void insertRecordBad(int id, String name);  //NOT A GOOD PRACTISE

    public void insertRecord(Teacher teacher);

    public Teacher findTeacherById(int id);

    public Teacher findTeacherByIdAndName(int id, String name);

    public List<Teacher> listEveryTeacher();

    public void deleteRecord();

    public void deleteRecordById(int id);

    public void updateRecord();

    public void updateRecordWithArgs(int id);


}