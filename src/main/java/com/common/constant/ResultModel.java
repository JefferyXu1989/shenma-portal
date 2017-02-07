package com.common.constant;

/**
 * 
 * @author "wb-luguangguang"
 *
 */
public class ResultModel {
	private String resultCode;
    private String message;
    private Object data;
	private Long systime;
    
    public ResultModel() {
		super();
	}
	public ResultModel(String resultCode, String message, Object data) {
		super();
		this.resultCode = resultCode;
		this.message = message;
		this.data = data;
		this.systime=System.currentTimeMillis();
	}
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
		systime=System.currentTimeMillis();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	public Long getSystime() {
		return systime;
	}

	public void setSystime(Long systime) {
		this.systime = systime;
	}
	@Override
	public String toString() {
		return "ResultModel [resultCode=" + resultCode + ", message=" + message
				+ ", data=" + data + ", systime=" + systime + "]";
	}
	
}
