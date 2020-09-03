package com.dhavalpanjwani.TestRTCF.handler;

import org.springframework.stereotype.Component;

import rtcf.application.ApplicationEventHandler;
import rtcf.application.ApplicationEventHandlerFactory;
import rtcf.model.ApplicationEventRequest;

@Component
public class CustomEventHandlerFactory extends ApplicationEventHandlerFactory {

	@Override
	public ApplicationEventHandler createEventHandler(ApplicationEventRequest eventRequest) {

		String type = eventRequest.getHeaders().get("type");

		switch (type) {
		case "Pizza":
			return new PizzaHandler();
		case "Pasta":
			return new PastaHandler();
		default:
			return new DefaultHandler();
		}
	}
	
}
