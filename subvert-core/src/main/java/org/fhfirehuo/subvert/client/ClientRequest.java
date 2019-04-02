package org.fhfirehuo.subvert.client;

import java.net.URI;

/**
 * 表示适用于所有通信协议的公共客户端请求的对象。 预计此对象是不可变的。
 * 
 * @author fire
 *
 */
public class ClientRequest implements Cloneable {

	protected URI uri;
	protected Boolean isRetriable = null;

	public ClientRequest() {
	}

	public ClientRequest(URI uri) {
		this.uri = uri;
	}

	public ClientRequest(URI uri, boolean isRetriable) {
		this.uri = uri;
		this.isRetriable = isRetriable;
	}

	public ClientRequest(ClientRequest request) {
		this.uri = request.uri;
		this.isRetriable = request.isRetriable;
	}

	public final URI getUri() {
		return uri;
	}

	protected final ClientRequest setUri(URI uri) {
		this.uri = uri;
		return this;
	}

	public boolean isRetriable() {
		return (Boolean.TRUE.equals(isRetriable));
	}

	protected final ClientRequest setRetriable(boolean isRetriable) {
		this.isRetriable = isRetriable;
		return this;
	}

	/**
	 * 使用新URI创建客户端请求。
	 * 
	 * 它首先尝试克隆请求，如果失败，它将使用复制构造函数.
	 * 
	 * 建议子类重写此方法以提供更有效的实现。
	 * 
	 * @param newURI
	 */
	public ClientRequest replaceUri(URI newURI) {
		ClientRequest req;
		try {
			req = (ClientRequest) this.clone();
		} catch (CloneNotSupportedException e) {
			req = new ClientRequest(this);
		}
		req.uri = newURI;
		return req;
	}

}
