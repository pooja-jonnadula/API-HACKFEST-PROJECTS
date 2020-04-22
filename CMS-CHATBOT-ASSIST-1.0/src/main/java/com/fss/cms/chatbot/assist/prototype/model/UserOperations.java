package com.fss.cms.chatbot.assist.prototype.model;

import io.swagger.annotations.ApiModelProperty;

/*import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString*/
public class UserOperations {
	@ApiModelProperty(notes = "UniqueID for operations")
	Integer operationID;
	@ApiModelProperty(notes = "Name of the operation")
	String operationName;

	public Integer getOperationID() {
		return operationID;
	}

	public void setOperationID(Integer operationID) {
		this.operationID = operationID;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	@Override
	public String toString() {
		return "UserOperations [operationID=" + operationID + ", operationName=" + operationName + ", getOperationID()="
				+ getOperationID() + ", getOperationName()=" + getOperationName() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public UserOperations(Integer operationID, String operationName) {
		super();
		this.operationID = operationID;
		this.operationName = operationName;
	}

}
