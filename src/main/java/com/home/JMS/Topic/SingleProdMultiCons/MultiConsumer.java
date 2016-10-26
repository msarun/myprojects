package com.home.JMS.Topic.SingleProdMultiCons;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Arun on 11/5/2015.
 */
public class MultiConsumer {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(new TopicCons());
        service.execute(new TopicCons());

    }
}

class TopicCons implements Runnable {

    @Override
    public void run() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);

        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createTopic("MyTopic");

            MessageConsumer consumer = session.createConsumer(destination);

            TextMessage message = (TextMessage) consumer.receive();
            System.out.println("Consumed Message: " + message.getText());

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
