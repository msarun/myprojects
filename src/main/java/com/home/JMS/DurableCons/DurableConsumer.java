package com.home.JMS.DurableCons;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Arun on 11/8/2015.
 */
public class DurableConsumer implements MessageListener{
    public static void main(String[] args) throws JMSException {
        new DurableConsumer().init();
    }

    private void init() throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);

        Connection connection = connectionFactory.createConnection();
        connection.setClientID("C1");

        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("T");

        MessageConsumer consumer = session.createDurableSubscriber(topic, "C1");
        consumer.setMessageListener(this);
        while(true) {

        }


    }

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage)message;
        try {
            System.out.println("Consumed: " + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
