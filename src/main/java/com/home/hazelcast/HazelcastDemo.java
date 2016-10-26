package com.home.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Arun on 1/10/2016.
 */
public class HazelcastDemo {
    public static void main(String[] args) {
        new HazelcastDemo().start();
    }

    private void start() {
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        Map<String, String> map = instance.getMap("MyMultiModeMap");
        map.put("Arun", "MS");
        map.put("Kiran", "MS");
        map.put("Shwetha", "Ravindra");

        Iterator iter = map.keySet().iterator();
        while(iter.hasNext()) {
            String key = (String)iter.next();
            System.out.println(key + " : " + map.get(key));
        }
    }
}
