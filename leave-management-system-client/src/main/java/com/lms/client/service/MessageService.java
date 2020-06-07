package com.lms.client.service;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

@Service("MessageService")
public class MessageService {

	
	@Resource(name = "lmsConnectionFactory", mappedName = "lms/lmsConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	@Resource(name = "lmsQueue", mappedName = "lms/lmsQueue")
	Queue queue;

	public void sendMessage(String messageBody) throws JMSException {
		Connection connection = connectionFactory.createConnection();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		MessageProducer messageProducer = session.createProducer(queue);
		TextMessage textMessage = session.createTextMessage(messageBody);
		messageProducer.send(textMessage);
		System.out.println(".Message sent to the server...");
	}
}
