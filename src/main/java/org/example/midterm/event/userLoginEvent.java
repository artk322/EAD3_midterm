package org.example.midterm.event;

import org.springframework.context.ApplicationEvent;

public class userLoginEvent extends ApplicationEvent {

    private  String name;

    public userLoginEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
