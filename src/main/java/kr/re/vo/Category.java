package kr.re.vo;

import lombok.Data;

@Data
public class Category {
	
	private String menuId;
	private String menuName;
	private String menuParent;
	private String menuDepth;
	private String menuVisible;

	private String status;     // HttpStatus
	private String message;     // Http Default Message
	private String errorMessage;     // Error Message to USER
	private String errorCode;     // Error Code

	public Category() {

	}

	public Category(String status, String message, String errorCode, String errorMessage) {
		this.status = status;
		this.message = message;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

}
