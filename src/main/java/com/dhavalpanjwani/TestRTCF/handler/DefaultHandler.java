package com.dhavalpanjwani.TestRTCF.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dhavalpanjwani.TestRTCF.MessageModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import rtcf.application.ApplicationEventHandler;
import rtcf.model.ApplicationEventRequest;
import rtcf.model.ApplicationEventResponse;

@Service
public class DefaultHandler implements ApplicationEventHandler {

	@SuppressWarnings("rawtypes")
	@Override
	public ApplicationEventResponse processAndTransformEvent(ApplicationEventRequest eventRequest) throws Exception {
		System.out.println("You are inside Default handler!");
		ApplicationEventResponse<MessageModel> eventResponse = new ApplicationEventResponse<MessageModel>();
		ObjectMapper mapper = new ObjectMapper();
		MessageModel messageModel;
		try {
			messageModel = mapper.readValue((String)eventRequest.getContent(), MessageModel.class);
			List<String> interests = new ArrayList<String>();
			interests.add(messageModel.getInterest());
			eventResponse.setInterests(interests);
			eventResponse.setContent(messageModel);
			//throw new Exception("Hey you!");
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return eventResponse;
	}

}
