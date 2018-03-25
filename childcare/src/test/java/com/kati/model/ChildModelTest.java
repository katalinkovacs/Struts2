package com.kati.model;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class ChildModelTest {



    @Autowired
    ChildDAOImplementation childDAOImplementation;


    @Test
    public void childDAOTest_whenChildInserted_thenViewDeleteSuccess() throws Exception{


        Child c = new Child();

        c.setId(299);
        c.setFullName("Sebastian");
        c.setAgeMonth(43);



        childDAOImplementation.insertRecord(c);


        Child c2 = childDAOImplementation.findChildById(299);

        assert("Sebastian".equals(c2.getFullName()));

        childDAOImplementation.deleteRecord(299);


    }
}
