package com.example.pushserver3.pushserver2.event.impl;

import com.example.pushserver3.pushserver2.event.Eventable;
import javafx.event.EventType;

/**
 * Created by palash on 12/7/17.
 */
public class BasicEvent implements Eventable {

    public String destination;

    public EventType type;

    public String link;

    @Override
    public Object process() {
        return null;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
