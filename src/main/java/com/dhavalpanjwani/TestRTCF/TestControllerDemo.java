package com.dhavalpanjwani.TestRTCF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestControllerDemo {
	
	
//    @Autowired
//    private JmsTemplate jmsTemplate;
//    
    
	@GetMapping("/greeting")
	public @ResponseBody String greetingWishes() {
		System.out.println("Inside rest greeting");
		return "Hello world";
	}
//	
//	@GetMapping("/event")
//	public @ResponseBody String eventHappened(@RequestParam String message) {
//		System.out.println("Inside event");
//        jmsTemplate.convertAndSend("applicationTopic", message);
//		return "Successfully triggered event!";
//	}

}
