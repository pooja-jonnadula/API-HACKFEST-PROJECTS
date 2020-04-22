package com.fss.cms.chatbot.assist.prototype.model;

import io.swagger.annotations.ApiModelProperty;

/*import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Data*/
public class AuthRequest {
	@ApiModelProperty(notes = "User ID to login CMS Assist", allowableValues = "500002,500003,500004")
	String userID;
	@ApiModelProperty(notes = "User Password to login CMS Assist", allowableValues = "Admin@123")
	String userPassword;
	@ApiModelProperty(notes = "User Type is type of user", allowableValues = "BankUser,CallCenterUser,CutomerPortalUser")
	String userType;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "AuthRequest [userID=" + userID + ", userPassword=" + userPassword + ", userType=" + userType + "]";
	}

	public AuthRequest(String userID, String userPassword, String userType) {
		super();
		this.userID = userID;
		this.userPassword = userPassword;
		this.userType = userType;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public AuthRequest() {
	}
}
