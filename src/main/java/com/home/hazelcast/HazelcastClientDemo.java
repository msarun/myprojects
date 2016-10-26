package com.home.hazelcast;

import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 * Created by Arun on 8/8/2016.
 */
public class HazelcastClientDemo {
    public static void main(String[] args) {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.addAddress("192.168.0.103:5701");
        HazelcastInstance instance = HazelcastClient.newHazelcastClient(clientConfig);
        IMap map = instance.getMap("MyMultiModeMap");
        System.out.println("Map Size:" + map.size());

    }
}
