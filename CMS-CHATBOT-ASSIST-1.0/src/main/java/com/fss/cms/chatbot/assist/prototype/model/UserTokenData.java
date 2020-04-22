package com.fss.cms.chatbot.assist.prototype.model;

public class UserTokenData {
	String userID;
	String userType;
	String userToken;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public UserTokenData(String userID, String userType, String userToken) {
		super();
		this.userID = userID;
		this.userType = userType;
		this.userToken = userToken;
	}

	@Override
	public String toString() {
		return "UserTokenData [userID=" + userID + ", userType=" + userType + ", userToken=" + userToken + "]";
	}

}
