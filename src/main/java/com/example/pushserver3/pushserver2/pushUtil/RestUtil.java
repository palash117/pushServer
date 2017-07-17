package com.example.pushserver3.pushserver2.pushUtil;

import com.example.pushserver3.pushserver2.event.Eventable;
import com.example.pushserver3.pushserver2.event.impl.BasicEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import com.example.pushserver3.pushserver2.pushConstants.PushConstants;
import java.net.URI;
import java.net.URISyntaxException;


/**
 * Created by palash on 17/7/17.
 */
public class RestUtil {

    private static RestTemplate restTemplate = new RestTemplate();

    public static String postPushEvent(String ip, Eventable event){
        String response = new String();

        URI uri = null;
        try {
            uri = new URI(ip + ":8080/pushEvent");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return  PushConstants.ERROR;

        }

        response = restTemplate.getForObject( uri, String.class);

        return response;
    }
}
