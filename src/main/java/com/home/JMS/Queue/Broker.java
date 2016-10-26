package com.home.JMS.Queue;

import org.apache.activemq.broker.BrokerService;

/**
 * Created by Arun on 11/5/2015.
 */
public class Broker {
    public static void main(String[] args) {
        BrokerService broker = new BrokerService();

        try {
            broker.addConnector("tcp://localhost:61616");
            broker.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
