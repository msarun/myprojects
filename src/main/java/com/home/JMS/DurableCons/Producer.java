package com.home.JMS.DurableCons;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Arun on 11/8/2015.
 */
public class Producer {
    public static void main(String[] args) {
        new Producer().init();
    }

    private void init() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection = null;
        Session session = null;

        try {
            connection = factory.createConnection();
            connection.start();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic("T");

            MessageProducer messageProducer = session.createProducer(destination);

            //Survives a Broker restart if messages are in-transit
            messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);

            messageProducer.send(session.createTextMessage("Hello"));
            System.out.println("Sent Message");

        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                session.close();
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }
    }
}
