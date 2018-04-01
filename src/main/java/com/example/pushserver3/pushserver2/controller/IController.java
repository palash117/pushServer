package com.example.pushserver3.pushserver2.controller;

import com.example.pushserver3.pushserver2.Request.Consumer;
import com.example.pushserver3.pushserver2.event.Eventable;
import com.example.pushserver3.pushserver2.event.impl.BasicEvent;
import com.example.pushserver3.pushserver2.event.impl.VolumeEvent;

import java.util.Set;

/**
 * Created by palash on 9/7/17.
 */
public interface IController {

    public String health();

    public String addConsumer(Consumer consumer);

    public Set<String> getConsumerNames();

    public String pushEvent(BasicEvent event);

    public String changeVolume(VolumeEvent event);



}
