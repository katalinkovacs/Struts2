package com.kati.action;

import com.kati.dataobject.MessageStore;
import com.opensymphony.xwork2.ActionSupport;


public class HelloAction extends ActionSupport {

    private MessageStore messageStore;


    public String execute() {

        messageStore = new MessageStore() ;

        return SUCCESS;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }


}
