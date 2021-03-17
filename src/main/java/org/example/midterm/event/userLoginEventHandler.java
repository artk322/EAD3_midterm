package org.example.midterm.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class userLoginEventHandler implements ApplicationListener<userLoginEvent> {

    @Override
    public void onApplicationEvent(userLoginEvent userLoginEvent) {
        System.out.println("Hello User with name: " + userLoginEvent.getName());
        System.out.println("Here is your options");
    }
}
