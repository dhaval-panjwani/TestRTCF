package com.dhavalpanjwani.TestRTCF;

import java.util.ArrayList;
import java.util.List;

import rtcf.application.ApplicationEventHandler;
import rtcf.model.ClientOutput;

public class TestRtcfHandler implements ApplicationEventHandler {

	@Override
	public ClientOutput processAndTransformEvent(String message) {
		ClientOutput clientOutput = new ClientOutput();
		clientOutput.setContent("Hey. We received your message : " + message);
		List<String> interests = new ArrayList<String>();
		interests.add("FirstTopic");
		interests.add("SecondTopic");
		clientOutput.setInterests(interests);
		// TODO Auto-generated method stub
		return clientOutput;
	}

}
