package com.example.pushserver3.pushserver2.event.impl;

import com.example.pushserver3.pushserver2.event.Eventable;
import com.example.pushserver3.pushserver2.event.type.EventDefinationType;

public class VolumeEvent implements Eventable {

    public String destination;

    public EventDefinationType type;

    public int volumePercentage;

    public int getVolumePercentage() {
        return volumePercentage;
    }

    public void setVolumePercentage(int volumePercentage) {
        this.volumePercentage = volumePercentage;
    }

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
