package com.dhavalpanjwani.TestRTCF;

public class MessageModel {
	String message;
	String interest;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	@Override
	public String toString() {
		return "MessageModel [message=" + message + ", interest=" + interest + "]";
	}
	
}
