package com.fss.cms.chatbot.assist.prototype.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fss.cms.chatbot.assist.prototype.model.AuthRequest;
import com.fss.cms.chatbot.assist.prototype.model.AuthResponse;
import com.fss.cms.chatbot.assist.prototype.service.ChatBotAssistService;

import io.swagger.annotations.Api;

@Api(description = "ChatBot Assist Endpoint : Authenticates users to access CMS")
@RestController("chatBotAssistController")
public class ChatBotAssistController {
	Logger log = LoggerFactory.getLogger(ChatBotAssistController.class);
	@Autowired
	ChatBotAssistService chatBotAssistService;

	@PostMapping(value = "${AUTH-API-URL}", produces = "application/json", consumes = "application/json")
	AuthResponse userAuthenticationHandler(@RequestBody AuthRequest authRequest) {

		log.info("User Authentication -Started");
		log.debug("userAuth Request->{}", authRequest.toString());
		AuthResponse authResponse = chatBotAssistService.authenticateUser(authRequest);
		log.debug(" userAuth Response->{}", authRequest.toString());

		return authResponse;
	}
	
}
