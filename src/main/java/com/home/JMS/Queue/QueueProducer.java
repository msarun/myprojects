package com.home.JMS.Queue;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Arun on 11/5/2015.
 */
public class QueueProducer {

    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    private static String subject = "VALLYSOFTQ"; //Queue Name

    public static void main(String[] args) throws JMSException {
        new QueueProducer().init();
    }

    private void init() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue("MyQueue");

            MessageProducer producer = session.createProducer(destination);
            //producer.setDeliveryMode(DeliveryMode.PERSISTENT);

            TextMessage myMsg = session.createTextMessage("Hello");
            producer.send(myMsg);
            System.out.println("Sent Message '" + myMsg.getText() + "'");
            session.close();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }


    }
}
