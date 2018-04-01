package com.example.pushserver3.pushserver2.service.impl;

import com.example.pushserver3.pushserver2.Request.Consumer;
import com.example.pushserver3.pushserver2.event.Eventable;
import com.example.pushserver3.pushserver2.event.impl.BasicEvent;
import com.example.pushserver3.pushserver2.event.impl.VolumeEvent;
import com.example.pushserver3.pushserver2.pushUtil.RestUtil;
import com.example.pushserver3.pushserver2.service.Servicable;
import com.example.pushserver3.pushserver2.singleton.ConsumerMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

/**
 * Created by palash on 11/7/17.
 */
@Service
public class BasicService implements Servicable {


    @Override
    public String pushEvent(BasicEvent event) throws URISyntaxException {

        ConsumerMap map = ConsumerMap.getInstance();
        RestTemplate restTemplate  = new RestTemplate();

        String destination = map.get(event.getDestination());

        String response = RestUtil.postPushEvent(destination, event);

        return response;
    }

    @Override
    public String addConsumer(Consumer consumer) {

        System.out.println(consumer);

        ConsumerMap map = ConsumerMap.getInstance();

        map.put(consumer.getName(), consumer.getIp());

        return  "Consumer added";
    }

    @Override
    public Set<String> getConsumerNames() {

        ConsumerMap map = ConsumerMap.getInstance();

        return map.getConsumerNames();
    }

    @Override
    public String changeVolume(VolumeEvent event) {

        ConsumerMap map = ConsumerMap.getInstance();
        RestTemplate restTemplate  = new RestTemplate();

        String destination = map.get(event.getDestination());

        String response = RestUtil.postChangeVoluem(destination, event);

        return response;
    }


}
