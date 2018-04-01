package com.example.pushserver3.pushserver2.pushUtil;

import com.example.pushserver3.pushserver2.event.Eventable;
import com.example.pushserver3.pushserver2.event.impl.BasicEvent;
import com.example.pushserver3.pushserver2.event.impl.VolumeEvent;
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
            String protocol = "http";
            String host = ip;
            int port = 8080;
            String path = "/pushEvent";
            String auth = null;
            String fragment = null;
            uri = new URI(protocol, auth, host, port, path, null, fragment);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return  PushConstants.ERROR;

        }

        try {
            response = restTemplate.postForObject(uri,event, String.class);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return response;
    }

    public static String postChangeVoluem(String destination, VolumeEvent event) {
        String response = new String();

        URI uri = null;
        try {
            String protocol = "http";
            String host = destination;
            int port = 8080;
            String path = "/changeVolume";
            String auth = null;
            String fragment = null;
            uri = new URI(protocol, auth, host, port, path, null, fragment);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return  PushConstants.ERROR;

        }

        try {
            response = restTemplate.postForObject(uri,event, String.class);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return response;
    }
}
