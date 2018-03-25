package com.kati.action;

import com.kati.model.Child;
import com.kati.model.ChildDAOImplementation;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component // default spring bean name --> readDataWithSpringAction
public class ReadDataWithSpringAction extends ActionSupport
{

    @Autowired
    ChildDAOImplementation childDAOImplementation;


    // property of this action class
    List<Child> childrenList = new ArrayList<Child>();


    public List<Child> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(ArrayList<Child> childrenList) {
        this.childrenList = childrenList;
    }




    public String execute(){

        childrenList = childDAOImplementation.listAllChildren();

        return SUCCESS;
    }
}
