package com.home.JMS.Queue.MultiProdCons;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Arun on 11/5/2015.
 */
public class MultiCons {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(int i = 0; i < 5; i++) {
            executorService.submit(new Consumer());
        }
    }
}

class Consumer implements Callable {

    @Override
    public Object call() throws Exception {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);

        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        javax.jms.Destination destination = session.createQueue("MyQ");

        MessageConsumer consumer = session.createConsumer(destination);
        Message message = consumer.receive();

        if(message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("Received Message: " + textMessage.getText() + " by Thread: " + Thread.currentThread().getName());
        }
        return null;
    }

}


