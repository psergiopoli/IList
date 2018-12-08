package br.com.psergiopoli.ilist.util;

public class Message {
	
	public Message(String message, Integer status) {
		this.message = message;
		this.status = status;
	}
	
	private String message;
	private Integer status;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

}
