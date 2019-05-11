package com.stream.big.data;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@SpringBootApplication
public class MeetupApp {

	private static final String MEETUP_ENDPOINT = "ws://stream.meetup.com/2/rsvps";
	
	public static void main(String[] args) {
		SpringApplication.run(MeetupApp.class, args);
	}
	
	@Bean
	public ApplicationRunner startup(MeetupWebSocketHandler meetupWebSocketHandler) {
		return args -> {
			WebSocketClient meetupWebSocketClient = new StandardWebSocketClient();
			meetupWebSocketClient.doHandshake(meetupWebSocketHandler, MEETUP_ENDPOINT);
		};
	}
}
