package com.home.JMS.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Arun on 11/5/2015.
 */
public class TopicProducer {
    public static void main(String[] args) throws JMSException {
        new TopicProducer().init();
    }

    private void init() throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);

        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue("MyTopic");

        Message message = session.createTextMessage("Hello World --> Topic");

        MessageProducer producer = session.createProducer(destination);

        producer.send(message);

        System.out.println("Published Message " + ((TextMessage)message).getText());

        session.close();
        connection.close();
    }
}

