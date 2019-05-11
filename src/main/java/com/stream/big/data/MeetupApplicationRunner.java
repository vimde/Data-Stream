package com.stream.big.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@Component
public class MeetupApplicationRunner implements ApplicationRunner {

	private static final String MEETUP_ENDPOINT = "ws://stream.meetup.com/2/rsvps";

	private final MeetupWebSocketHandler meetupWebSocketHandler;

	@Autowired
	public MeetupApplicationRunner(MeetupWebSocketHandler meetupWebSocketHandler) {
		this.meetupWebSocketHandler = meetupWebSocketHandler;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		WebSocketClient meetupWebSocketClient = new StandardWebSocketClient();
		meetupWebSocketClient.doHandshake(meetupWebSocketHandler, MEETUP_ENDPOINT);
	}

}
