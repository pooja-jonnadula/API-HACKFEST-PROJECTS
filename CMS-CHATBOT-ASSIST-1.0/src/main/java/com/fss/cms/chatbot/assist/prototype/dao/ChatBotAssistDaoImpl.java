package com.fss.cms.chatbot.assist.prototype.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fss.cms.chatbot.assist.prototype.model.AuthRequest;
import com.fss.cms.chatbot.assist.prototype.model.UserOperations;
import com.fss.cms.chatbot.assist.prototype.model.UserTokenData;

@Repository("chatBotAssistDaoImpl")
public class ChatBotAssistDaoImpl implements ChatBotAssistDao {
	Logger log = LoggerFactory.getLogger(ChatBotAssistDaoImpl.class);

	static HashMap<String, UserTokenData> tokenMap = new HashMap<>();

	@Override
	public boolean authenticateUser(AuthRequest req) {
		HashMap<String, AuthRequest> userDataMap = null;
		boolean authStatus = false;
		try {
			userDataMap = fetchUserData();
			if (req.getUserID() != null && userDataMap.containsKey(req.getUserID())) {
				log.debug("user exists" + req.getUserID() + ":: verifying password and type..");
				AuthRequest userData = userDataMap.get(req.getUserID());
				if (req.getUserPassword() != null && req.getUserPassword().equals(userData.getUserPassword())) {
					log.debug("user pwd matched " + req.getUserID() + ":: verifying  type..");
					if (req.getUserType() != null && req.getUserType().equals(userData.getUserType())) {
						authStatus = true;
						log.debug("Auth Success! for user ID :" + req.getUserID());
					}
				}
			}
		} catch (Exception e) {
			log.debug("Exception during user authentication", e);
			log.error("Error :{}", e);
		}
		return authStatus;
	}

	private HashMap<String, AuthRequest> fetchUserData() {

		HashMap<String, AuthRequest> userDataMap = null;
		try {
			userDataMap = new HashMap<>();
			userDataMap.put("500002", new AuthRequest("500002", "Admin@123", "BankUser"));
			userDataMap.put("500003", new AuthRequest("500003", "Admin@123", "CallCenterUser"));
			userDataMap.put("500004", new AuthRequest("500004", "Admin@123", "CustomerPortalUser"));
		} catch (Exception e) {
			log.debug("Exception :", e);
			log.debug("Error :", e);
		}
		return userDataMap;
	}

	public List<UserOperations> fetchUseropsByUserType(String userType) {
		HashMap<String, List<UserOperations>> useropsMap = null;
		List<UserOperations> userTypOps = null;
		try {
			useropsMap = new HashMap<>();
			useropsMap = fetchUserops();
			userTypOps = useropsMap.get(userType);

		} catch (Exception e) {
			log.debug("Exception while fetchgs usertype ops -", e);
			log.error("Error {}", e);
		}
		return userTypOps;
	}

	private HashMap<String, List<UserOperations>> fetchUserops() {
		HashMap<String, List<UserOperations>> useropsMap = null;
		List<UserOperations> useropsBankUser = null;
		List<UserOperations> useropsCallCenterUser = null;
		List<UserOperations> useropsCustPortalUser = null;
		try {
			useropsMap = new HashMap<>();
			useropsBankUser = new ArrayList<>();
			useropsBankUser.add(new UserOperations(1, "Branch Menu Navigation"));
			useropsBankUser.add(new UserOperations(2, "About Branch"));
			useropsBankUser.add(new UserOperations(3, "Product Configuration"));
			// call center user ops
			useropsCallCenterUser = new ArrayList<>();
			useropsCallCenterUser.add(new UserOperations(useropsBankUser.size() + 1, "Call Center Menu Navigation"));
			useropsCallCenterUser.add(new UserOperations(useropsBankUser.size() + 2, "About Call Center"));
			useropsCallCenterUser.add(new UserOperations(useropsBankUser.size() + 3, "Call Initition"));
			useropsCallCenterUser.add(new UserOperations(useropsBankUser.size() + 4, "Call Close"));
			useropsCallCenterUser.add(new UserOperations(useropsBankUser.size() + 5, "User Authentication in Call"));
			// cust portal usr ops
			useropsCustPortalUser = new ArrayList<>();
			useropsCustPortalUser.add(new UserOperations(useropsBankUser.size() + useropsCallCenterUser.size() + 1,
					"Customer Portal Menu Navigation"));
			useropsCustPortalUser.add(new UserOperations(useropsBankUser.size() + useropsCallCenterUser.size() + 2,
					"About Customer Portal"));
			useropsCustPortalUser.add(
					new UserOperations(useropsBankUser.size() + useropsCallCenterUser.size() + 3, "Account Balance"));
			useropsCustPortalUser.add(new UserOperations(useropsBankUser.size() + useropsCallCenterUser.size() + 4,
					"Inflow and OutFlow of Month for Card"));
			useropsCustPortalUser.add(new UserOperations(useropsBankUser.size() + useropsCallCenterUser.size() + 5,
					"Block Card -Temporary"));
			useropsCustPortalUser
					.add(new UserOperations(useropsBankUser.size() + useropsCallCenterUser.size() + 6, "UnBlock Card"));
			useropsCustPortalUser.add(new UserOperations(useropsBankUser.size() + useropsCallCenterUser.size() + 7,
					"HotList Card -Permanant"));
			useropsMap.put("BankUser", useropsBankUser);
			useropsMap.put("CallCenterUser", useropsCallCenterUser);
			useropsMap.put("CustomerPortalUser", useropsCustPortalUser);

		} catch (Exception e) {
			log.debug("Exception while fetching userOps by UserType", e);
			log.error("Error {}", e);
		}
		return useropsMap;
	}

	@Override
	public boolean saveToken(String userID, UserTokenData tokenData) {
		boolean saveFlag = true;
		try {
			tokenMap.put(userID, tokenData);
		} catch (Exception e) {
			log.debug("Exception in saving token:{}", e);
			log.error("Error in saving token:{}", e);
			saveFlag = false;
		}
		return saveFlag;
	}

}
