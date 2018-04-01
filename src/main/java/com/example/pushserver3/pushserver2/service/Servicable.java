package com.example.pushserver3.pushserver2.service;

import com.example.pushserver3.pushserver2.Request.Consumer;
import com.example.pushserver3.pushserver2.event.Eventable;
import com.example.pushserver3.pushserver2.event.impl.BasicEvent;
import com.example.pushserver3.pushserver2.event.impl.VolumeEvent;

import java.net.URISyntaxException;
import java.util.Set;

/**
 * Created by palash on 11/7/17.
 */
public interface Servicable {

    public String pushEvent(BasicEvent event) throws URISyntaxException;

    public String addConsumer(Consumer consumer);

    public Set<String> getConsumerNames();

    public String changeVolume(VolumeEvent event);
}
