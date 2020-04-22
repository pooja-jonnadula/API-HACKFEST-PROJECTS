package com.fss.cms.chatbot.assist.prototype.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fss.cms.chatbot.assist.prototype.dao.ChatBotAssistDao;
import com.fss.cms.chatbot.assist.prototype.model.AuthRequest;
import com.fss.cms.chatbot.assist.prototype.model.AuthResponse;
import com.fss.cms.chatbot.assist.prototype.model.UserTokenData;

@Service("chatBotAssistService")
public class ChatBotAssistService {
	@Autowired
	ChatBotAssistDao chatBotAssistDao;

	Logger log = LoggerFactory.getLogger(ChatBotAssistService.class);

	public AuthResponse authenticateUser(AuthRequest req) {
		AuthResponse resp = null;
		try {
			boolean isUserAuthenticated = chatBotAssistDao.authenticateUser(req);
			log.debug("Auth Status :{} for userID :{}", isUserAuthenticated, req.getUserID());
			if (isUserAuthenticated) {
				resp = new AuthResponse();
				resp.setUserOperations(chatBotAssistDao.fetchUseropsByUserType(req.getUserType()));
				resp.setToken(generateAndSaveToken(req));
			} else {
				resp = new AuthResponse();
				resp.setErrMsg("Invalid User");
			}
		} catch (Exception e) {
			log.debug("Exception during authprocessing:", e);
			log.error("Error ", e);
		}
		return resp;
	}

	private String generateAndSaveToken(AuthRequest req) {
		String tokn = null;
		try {
			int tkn = new Random().nextInt();
			tokn = String.valueOf(tkn);
			UserTokenData tokenData = new UserTokenData(req.getUserID(), req.getUserType(), tokn);
			log.debug("token ::" + tokn + ", for user ID :" + req.getUserID());
			chatBotAssistDao.saveToken(req.getUserID(), tokenData);
		} catch (Exception e) {
			log.debug("Exception while generating token", e);
			log.error("Exception while generating token", e);
		}
		return tokn;
	}

}
