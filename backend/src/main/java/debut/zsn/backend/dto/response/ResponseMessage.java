package debut.zsn.backend.dto.response;

import debut.zsn.backend.model.User;

public class ResponseMessage {
	private String message;
	private User user;

	public ResponseMessage(String message, User user) {
		this.message = message;
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser(){
		return user;
	}

	public void setUser(User user){
		this.user = user;
	}
}
