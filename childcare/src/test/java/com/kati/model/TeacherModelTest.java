package com.kati.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class TeacherModelTest {

    @Autowired
    TeacherDAOImplementation teacherDAOImplementation;

    @Test
    public void teacherDAOTest() throws Exception{

        Teacher teacher = new Teacher();

        teacher.setId(300);
        teacher.setName("Random");


        teacherDAOImplementation.insertRecord(teacher);

        Teacher teacher2 = teacherDAOImplementation.findTeacherById(300);

        assert("Random".equals(teacher.getName()));

        teacherDAOImplementation.deleteRecordById(300);


    }
}
