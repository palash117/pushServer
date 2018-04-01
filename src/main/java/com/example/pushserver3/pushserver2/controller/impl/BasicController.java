package com.example.pushserver3.pushserver2.controller.impl;

import com.example.pushserver3.pushserver2.Request.Consumer;
import com.example.pushserver3.pushserver2.controller.IController;
import com.example.pushserver3.pushserver2.event.Eventable;
import com.example.pushserver3.pushserver2.event.impl.BasicEvent;
import com.example.pushserver3.pushserver2.event.impl.VolumeEvent;
import com.example.pushserver3.pushserver2.service.Servicable;
import com.example.pushserver3.pushserver2.singleton.ConsumerMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.Set;

/**
 * Created by palash on 9/7/17.
 */
@RestController
public class BasicController implements IController {


    @Autowired
    Servicable service;

    @RequestMapping("/")
    @Override
    public String health() {
        return "API IS UP";
    }

    @RequestMapping("/addConsumer")
    @Override
    public String addConsumer(@RequestBody  Consumer consumer) {

        return service.addConsumer(consumer);
    }

    @RequestMapping("/getConsumerNames")
    @Override
    public Set<String> getConsumerNames() {

       return service.getConsumerNames();
    }

    @RequestMapping("/pushEvent")
    @Override
    public String pushEvent(@RequestBody  BasicEvent event) {

        try {
            return service.pushEvent(event);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return "error";
    }

    @RequestMapping("/changeVolume")
    @Override
    public String changeVolume(@RequestBody VolumeEvent event) {

        try {
            return service.changeVolume(event);
        } catch (
                Exception e) {
            e.printStackTrace();
        }

        return "error";
    }

}
