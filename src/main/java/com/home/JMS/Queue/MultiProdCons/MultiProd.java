package com.home.JMS.Queue.MultiProdCons;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Arun on 11/5/2015.
 */
public class MultiProd {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i =0; i< 10; i++) {
            executorService.submit(new Producer());
        }
    }

}

class Producer implements Callable {

    @Override
    public Object call() throws Exception {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue("MyQ");

        MessageProducer producer = session.createProducer(destination);

        Message message = session.createTextMessage("Hello from Thread: " + Thread.currentThread().getName());
        System.out.println("Sending Message from Thread:" + Thread.currentThread().getName() );
        producer.send(message);
        connection.close();
        session.close();
        return null;
    }
}
