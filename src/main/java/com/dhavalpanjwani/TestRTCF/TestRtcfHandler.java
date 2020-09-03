package com.dhavalpanjwani.TestRTCF;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import rtcf.application.ApplicationEventHandler;
import rtcf.model.ApplicationEventRequest;
import rtcf.model.ApplicationEventResponse;

@Service
public class TestRtcfHandler implements ApplicationEventHandler {

	@SuppressWarnings("rawtypes")
	@Override
	public ApplicationEventResponse processAndTransformEvent(ApplicationEventRequest eventRequest) throws Exception {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventResponse;
	}

}
