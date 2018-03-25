package com.kati.action;

import com.kati.model.ChildDAOImplementation;
import com.kati.model.Teacher;
import com.kati.model.TeacherDAOImplementation;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;


@Component // default spring bean name --> readTeacherDataWithSpringAction
public class ReadTeacherDataWithSpringAction extends ActionSupport {

    @Autowired
    TeacherDAOImplementation teacherDAOImplementation;

    // property of this action class
    List<Teacher> teacherList = new ArrayList<Teacher>();

    // SETTERS GETTERS
    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }


    public String execute(){

        teacherList = teacherDAOImplementation.listEveryTeacher();

        return SUCCESS;
    }

}
