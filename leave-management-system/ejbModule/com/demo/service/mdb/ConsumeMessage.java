package com.demo.service.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(
		activationConfig = { 
				@ActivationConfigProperty(propertyName = "destinationName", propertyValue = "lms/lmsQueue"),
				@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")}
		, mappedName = "lms/lmsQueue")
public class ConsumeMessage implements MessageListener {

	public ConsumeMessage() {}
	
    public void onMessage(Message message) {
    	try {
			System.out.println(".Messsage Arrived: " + message.getBody(String.class));
		} catch (JMSException e) {
			e.printStackTrace();
		}
    }

}
