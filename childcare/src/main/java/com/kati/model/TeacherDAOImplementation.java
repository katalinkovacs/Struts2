package com.kati.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class TeacherDAOImplementation implements TeacherDao {
    // TeacherDAOImplementation must have JdbcOperations!!!
    private JdbcOperations jdbcOperations;

    @Autowired
    public TeacherDAOImplementation(JdbcOperations jdbcOperations) {

        this.jdbcOperations = jdbcOperations;
    }


    public void insertRecord(Teacher teacher){

        String sql = "INSERT INTO Teacher (id, Name) VALUES (" + teacher.getId() + ",     \"" + teacher.getName() + "\" "    + ")";
        jdbcOperations.update(sql);
        System.out.println("Created Record ID is = " +teacher.getId() +" Name is: " + teacher.getName());
        return;

    }

    public Teacher findTeacherById(int id){
        // SQL --> select id, name from katidb.teacher where id = 4;
        String sql = "SELECT id, name FROM Teacher WHERE id = ? ";   // ? --> ARGS
        System.out.println("-----------------------");
        Teacher teacher = (Teacher) jdbcOperations.queryForObject(sql, new Object[]{id}, new TeacherMapper());
        return teacher;

    }

    public Teacher findTeacherByIdAndName(int id, String name){

        String sql = "SELECT id, name FROM Teacher WHERE id = ? AND name = ?";
        System.out.println("-----------------------");
        Teacher teacher = (Teacher) jdbcOperations.queryForObject(sql, new Object[]{id, name}, new TeacherMapper());
        return teacher;

    }

    public List<Teacher> listEveryTeacher() {

        String SQL = "SELECT * from Teacher";
        List <Teacher> teacherList = jdbcOperations.query(SQL, new TeacherMapper());

        System.out.println("Looping through TeacherList:");
        for (Teacher currentTeacher : teacherList) {
            System.out.println("ID : " + currentTeacher.getId() +", Name : " + currentTeacher.getName() );

        }

        return teacherList;
    }

    public void deleteRecord(){

        String SQL = "DELETE FROM Teacher WHERE ID = 2";
        jdbcOperations.update(SQL);
        return;

    }

    public void deleteRecordById(int id){

        String SQL = "DELETE FROM Teacher WHERE ID = " +id +"";
        jdbcOperations.update(SQL);
        return;
    }



    public  void updateRecord(){

        String sql = "UPDATE Teacher SET Name = 'JillyBilly' WHERE Id = 7";
        jdbcOperations.update(sql);
        return;

    }

    public  void updateRecordWithArgs(int id){

        String sql = "UPDATE Teacher SET Name = 'Jill' WHERE Id = " +id +"";
        jdbcOperations.update(sql);
        return;

    }




}
