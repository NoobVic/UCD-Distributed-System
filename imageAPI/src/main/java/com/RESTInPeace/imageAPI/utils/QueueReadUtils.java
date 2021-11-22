package com.RESTInPeace.imageAPI.utils;

import com.RESTInPeace.models.ImageQueueWrapper;
import com.RESTInPeace.models.constants.ImageAPiConstants;
import lombok.NonNull;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import java.util.Random;

public class QueueReadUtils {

    public static void readQueueAndSavePicture(){
        try {
            final ConnectionFactory factory = new ActiveMQConnectionFactory(ImageAPiConstants.QUEUE_ADDRESS);
            final Connection connection = factory.createConnection();

            connection.setClientID(String.format("imageAPI%d", new Random().nextInt(99999)));

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Queue requestsQueue = session.createQueue(ImageAPiConstants.QUEUE_NAME);
            MessageConsumer requestsQueueConsumer = session.createConsumer(requestsQueue);

            // start the connection
            connection.start();

            while (true) {
                // block to wait for response
                Message message = requestsQueueConsumer.receive();
                System.out.println("Received the picture");

                // check for the message type
                if (message instanceof ObjectMessage) {
                    Object msgContent = ((ObjectMessage) message).getObject();

                    if (msgContent instanceof ImageQueueWrapper) {

                        ImageQueueWrapper request = (ImageQueueWrapper) msgContent;

                        S3TalkUtils.saveImageToServer(request.file, request.fileName);
                        System.out.println("Saved the picture");

                        Thread.sleep(100);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
