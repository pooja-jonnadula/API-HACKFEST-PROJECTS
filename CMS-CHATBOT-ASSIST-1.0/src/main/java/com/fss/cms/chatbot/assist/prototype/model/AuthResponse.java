package com.fss.cms.chatbot.assist.prototype.model;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/*import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString*/
public class AuthResponse {
	@ApiModelProperty(notes = "User Token access CMS Assist")
	String token;
	@ApiModelProperty(notes = "UserOperations List based on User Type")
	List<UserOperations> userOperations;
	@ApiModelProperty(notes = "Error message to display if any error occurrs in processing Auth API")
	String errMsg;

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<UserOperations> getUserOperations() {
		return userOperations;
	}

	public void setUserOperations(List<UserOperations> userOperations) {
		this.userOperations = userOperations;
	}

	@Override
	public String toString() {
		return "AuthResponse [token=" + token + ", userOperations=" + userOperations + "]";
	}

	public AuthResponse(String token, List<UserOperations> userOperations) {
		super();
		this.token = token;
		this.userOperations = userOperations;
	}

	public AuthResponse() {
	}
}
