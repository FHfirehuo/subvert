package org.fhfirehuo.subvert.client;

public interface IClient<S extends ClientRequest, T extends IResponse> {


	/**
	 * 执行请求并返回响应。 预计不会重试，并且会直接抛出所有异常。
	 */
    public T execute(S request) throws Exception; 
}
