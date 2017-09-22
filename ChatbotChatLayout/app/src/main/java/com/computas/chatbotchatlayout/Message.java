package com.computas.chatbotchatlayout;

/**
 * Created by kthx on 21.09.2017.
 */

public class Message {

    private String message;
    private int viewType;

    public Message(String message, int viewType){
        this.message = message;
        this.viewType = viewType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getViewType() {
        return viewType;
    }

}


