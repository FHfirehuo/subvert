package org.fhfirehuo.subvert.client;

import java.io.Closeable;
import java.net.URI;
import java.util.Map;

/**
 * 客户端框架的响应接口。
 */
public interface IResponse extends Closeable {

	/**
	 * 如果响应可用，则返回原始实体
	 */
	public Object getPayload() throws ClientException;

	/**
	 * 一个“窥视”的API。 用于检查您的服务是否返回了与实体的响应
	 */
	public boolean hasPayload();

	/**
	 * @return 如果响应被视为成功，则为true，例如，200  响应http协议的代码。
	 */
	public boolean isSuccess();

	/**
	 * 返回生成此响应的Request URI
	 */
	public URI getRequestedURI();

	/**
	 * 
	 * @return 响应中的标头（如果有）
	 */
	public Map<String, ?> getHeaders();
}
