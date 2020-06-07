package com.lms.client.web;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lms.client.service.MessageService;

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@GetMapping("/message/{body}")
	public void sendMessage(@PathVariable(value = "body") String messageBody) throws JMSException {
		messageService.sendMessage(messageBody);
	}
}
