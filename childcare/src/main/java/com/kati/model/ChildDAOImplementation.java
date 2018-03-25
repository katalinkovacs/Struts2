package com.kati.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

//import javax.sql.DataSource;

@Repository
public class ChildDAOImplementation implements ChildDAO{

        // ChildDAOImplementation must have JdbcOperations!!!
        private JdbcOperations jdbcOperations;

        @Autowired
        public ChildDAOImplementation(JdbcOperations jdbcOperations) {

            this.jdbcOperations = jdbcOperations;
        }


        public void insertRecord(Child child) {

            String sql = "INSERT INTO Child (id, fullName, ageMonth) VALUES (" + child.getId() + ",     \"" + child.getFullName() + "\"," + child.getAgeMonth() + ")";
            jdbcOperations.update(sql);
            //System.out.println("Created Record ID is = " +child.getId() +" Name is: " + child.getFullName());
            return;
        }


        public Child findChildById(int id) {

            String SQL = "select * from Child where id = ?";
            //Child child = (Child) jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new ChildMapper());
            Child child = (Child) jdbcOperations.queryForObject(SQL, new Object[]{id}, new ChildMapper());

            return child;

        }


        public Child findChildByName(String fullName) {

            String SQL = "SELECT * from Child WHERE fullName = ?";
            //Child child = (Child) jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new ChildMapper());
            Child child = (Child) jdbcOperations.queryForObject(SQL, new Object[]{fullName}, new ChildMapper());

            return child;

        }

    /*    public List<Child> listAllChildren() {

            String SQL = "select * from Child";
            //List <Child> children = jdbcTemplateObject.query(SQL, new ChildMapper());
            List <Child> children = jdbcOperations.query(SQL, new ChildMapper());
            return children;

        }*/

        public List<Child> listAllChildren() {

            String SQL = "SELECT * from Child";
            List <Child> childrenList = jdbcOperations.query(SQL, new ChildMapper());

            System.out.println("Looping through ChildrenList:");
            for (Child currentChild : childrenList) {
            System.out.println("ID is: " + currentChild.getId() +", Name is: " + currentChild.getFullName() +", Age is: " + currentChild.getAgeMonth() +" months" );

        }

            return childrenList;
        }


        public void deleteRecord(int id) {

            String SQL = "delete from Child where id = ?";
            //jdbcTemplateObject.update(SQL); --> NOT WORKING
            jdbcOperations.update(SQL, id);

            System.out.println("Deleted Record with ID = " + id );
            return;

        }

        public void updateRecord(int id, int ageMonth){

            String SQL = "update Child set ageMonth = ? where id = ?";

            String updateQuery = "update Student set age = ? where id = ?";
            //jdbcTemplateObject.update(updateQuery, age, id);

            //jdbcTemplateObject.update(SQL); --> NOT WORKING
            jdbcOperations.update(SQL, ageMonth, id);
            //System.out.println("Updated Record with ID = " + id );
            return;
        }

}
