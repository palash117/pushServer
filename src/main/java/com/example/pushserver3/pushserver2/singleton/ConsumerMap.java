package com.example.pushserver3.pushserver2.singleton;

import java.net.URI;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by palash on 9/7/17.
 */

public class ConsumerMap {

    private HashMap<String, String> map;

    public void put(String key, String uri){
        map.put(key, uri);
    }

    public String get(String key){
        return map.get(key);
    }

    public HashMap getMap(){
        return map;
    }

    public Set<String> getConsumerNames(){
        return map.keySet();
    }
    private static ConsumerMap ourInstance = new ConsumerMap();

    public static ConsumerMap getInstance() {
        return ourInstance;
    }

    private ConsumerMap() {
        map = new HashMap<>();
    }
}
