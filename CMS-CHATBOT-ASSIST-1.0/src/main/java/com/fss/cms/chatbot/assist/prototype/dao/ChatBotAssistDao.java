package com.fss.cms.chatbot.assist.prototype.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fss.cms.chatbot.assist.prototype.model.AuthRequest;
import com.fss.cms.chatbot.assist.prototype.model.UserOperations;
import com.fss.cms.chatbot.assist.prototype.model.UserTokenData;

@Component("chatBotAssistDao")
public interface ChatBotAssistDao {

	boolean authenticateUser(AuthRequest req);

	List<UserOperations> fetchUseropsByUserType(String userType);

	boolean saveToken(String userID, UserTokenData tokenData);
}
