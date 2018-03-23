package com.kati.action;

import com.opensymphony.xwork2.ActionSupport;

public class Action02 extends ActionSupport{

    private String name;

    public String execute() throws Exception {
        if ("Kati".equals(name) || "Sebi".equals(name) ) {
            //return SUCCESS;
            return Action03.GOOD;
        } else {
            //return ERROR;
            return Action03.BAD;

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
