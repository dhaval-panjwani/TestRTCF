package com.dhavalpanjwani.TestRTCF.handler;

import java.util.ArrayList;
import java.util.List;

import com.dhavalpanjwani.TestRTCF.MessageModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import rtcf.application.ApplicationEventHandler;
import rtcf.model.ApplicationEventRequest;
import rtcf.model.ApplicationEventResponse;

public class PizzaHandler implements ApplicationEventHandler {
	@SuppressWarnings("rawtypes")
	@Override
	public ApplicationEventResponse processAndTransformEvent(ApplicationEventRequest eventRequest) throws Exception {
		System.out.println("You are inside Pizza handler!");
		ApplicationEventResponse<MessageModel> eventResponse = new ApplicationEventResponse<MessageModel>();
		ObjectMapper mapper = new ObjectMapper();
		MessageModel messageModel;
		try {
			messageModel = mapper.readValue((String) eventRequest.getContent(), MessageModel.class);
			List<String> interests = new ArrayList<String>();
			interests.add("Pizza");
			eventResponse.setInterests(interests);
			eventResponse.setContent(messageModel);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return eventResponse;
	}

}
