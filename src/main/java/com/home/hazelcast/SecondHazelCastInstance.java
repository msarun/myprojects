package com.home.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;

/**
 * Created by Arun on 2/17/2016.
 */
public class SecondHazelCastInstance {
    public static void main(String[] args) {
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        Map<String, String> map = instance.getMap("MyMultiModeMap");
        System.out.println(map.get("Arun"));
    }
}
