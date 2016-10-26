package com.home.JMS.Queue;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Arun on 11/5/2015.
 */
public class QueueConsumer {

    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    // default broker URL is : tcp://localhost:61616"

    public static void main(String[] args) throws JMSException {
        new QueueConsumer().init();
    }

    private void init() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue("MyQueue");

            MessageConsumer consumer = session.createConsumer(destination);

            Message message = consumer.receive();

            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                System.out.println("Received Message '" + textMessage.getText()
                        + "'");
            }

            session.close();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
