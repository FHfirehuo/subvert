package org.fhfirehuo.subvert.client;

public class ClientException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1974304761219916484L;

	public enum ErrorType {
		GENERAL, 
		CONFIGURATION, 
		NUMBEROF_RETRIES_EXEEDED, 
		NUMBEROF_RETRIES_NEXTSERVER_EXCEEDED,
		SOCKET_TIMEOUT_EXCEPTION, 
		READ_TIMEOUT_EXCEPTION, 
		UNKNOWN_HOST_EXCEPTION, 
		CONNECT_EXCEPTION, 
		CLIENT_THROTTLED,
		SERVER_THROTTLED, 
		NO_ROUTE_TO_HOST_EXCEPTION, 
		CACHE_MISSING;

		static String getName(int errorCode) {
			if (ErrorType.values().length >= errorCode) {
				return ErrorType.values()[errorCode].name();
			} else {
				return "UNKNOWN ERROR CODE";
			}
		}
	}

	protected int errorCode;
	protected String message;
	protected Object errorObject;
	protected ErrorType errorType = ErrorType.GENERAL;

	public ClientException(String message) {
		this(0, message, null);
	}

	public ClientException(int errorCode) {
		this(errorCode, null, null);
	}

	public ClientException(int errorCode, String message) {
		this(errorCode, message, null);
	}

	public ClientException(Throwable chainedException) {
		this(0, null, chainedException);
	}

	public ClientException(String message, Throwable chainedException) {
		this(0, message, chainedException);
	}

	public ClientException(int errorCode, String message, Throwable chainedException) {
		super((message == null && errorCode != 0) ? ", code=" + errorCode + "->" + ErrorType.getName(errorCode)
				: message, chainedException);
		this.errorCode = errorCode;
		this.message = message;
	}

	public ClientException(ErrorType error) {
		this(error.ordinal(), null, null);
		this.errorType = error;
	}

	public ClientException(ErrorType error, String message) {
		this(error.ordinal(), message, null);
		this.errorType = error;
	}

	public ClientException(ErrorType error, String message, Throwable chainedException) {
		super((message == null && error.ordinal() != 0) ? ", code=" + error.ordinal() + "->" + error.name() : message,
				chainedException);
		this.errorCode = error.ordinal();
		this.message = message;
		this.errorType = error;
	}

	public ErrorType getErrorType() {
		return errorType;
	}

	public int getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return this.message;
	}

	public void setErrorMessage(String msg) {
		this.message = msg;
	}

	public Object getErrorObject() {
		return this.errorObject;
	}

	public void setErrorObject(Object errorObject) {
		this.errorObject = errorObject;
	}

	/**
	 * 返回与此类异常关联的消息。
	 *
	 * @return 与当前异常关联的消息
	 */
	public String getInternalMessage() {
		return "{no message: " + errorCode + "}";
	}

}
