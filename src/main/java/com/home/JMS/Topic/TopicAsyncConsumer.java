package com.home.JMS.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Arun on 11/5/2015.
 */
public class TopicAsyncConsumer implements MessageListener{
    public static void main(String[] args) throws JMSException {
        new TopicAsyncConsumer().init();
    }

    private void init() throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);

        Connection connection = connectionFactory.createConnection();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        connection.start();

        Destination destination = session.createQueue("MyTopic");

        MessageConsumer messageConsumer = session.createConsumer(destination);

        //Message message = messageConsumer.receive();

        messageConsumer.setMessageListener(this);


    while(true) {

    }
    }

    @Override
    public void onMessage(Message message) {
        if(message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage)message;
            try {
                System.out.println("Consumed Message: " + textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
