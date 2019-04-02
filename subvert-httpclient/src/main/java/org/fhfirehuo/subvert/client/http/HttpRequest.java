package org.fhfirehuo.subvert.client.http;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.fhfirehuo.subvert.client.ClientRequest;

public class HttpRequest extends ClientRequest {

	public enum Verb {
		GET("GET"), PUT("PUT"), PATCH("PATCH"), POST("POST"), DELETE("DELETE"), OPTIONS("OPTIONS"), HEAD("HEAD");

		private final String verb; // http method

		Verb(String verb) {
			this.verb = verb;
		}

		public String verb() {
			return verb;
		}
	}

	protected CaseInsensitiveHttpHeaders httpHeaders = new CaseInsensitiveHttpHeaders();
	protected Map<String, String> queryParams = new HashMap<String, String>();
	private Object entity;
	protected Verb verb;

	HttpRequest() {
		this.verb = Verb.GET;
	}

	public static class Builder {

		private HttpRequest request = new HttpRequest();

		public Builder() {
		}

		public Builder(HttpRequest request) {
			this.request = request;
		}

		public Builder uri(URI uri) {
			request.setUri(uri);
			return this;
		}

		public Builder header(String name, String value) {
			request.httpHeaders.addHeader(name, value);
			return this;
		}

		Builder headers(CaseInsensitiveHttpHeaders headers) {
			request.httpHeaders = headers;
			return this;
		}

		Builder queryParams(Map<String, String> queryParams) {
			request.queryParams = queryParams;
			return this;
		}

		public Builder setRetriable(boolean retriable) {
			request.setRetriable(retriable);
			return this;
		}

		public Builder verb(Verb verb) {
			request.verb = verb;
			return this;
		}

		public Builder entity(Object entity) {
			request.entity = entity;
			return this;
		}

		public HttpRequest build() {
			return request;
		}

	}

	public Map<String, String> getQueryParams() {
		return queryParams;
	}

	public Verb getVerb() {
		return verb;
	}

	public HttpHeaders getHttpHeaders() {
		return httpHeaders;
	}

	public Object getEntity() {
		return entity;
	}

	/**
	 * Test if the request is retriable. If the request is a {@link Verb#GET} and
	 * {@link Builder#setRetriable(boolean)} is not called, returns true. Otherwise,
	 * returns value passed in {@link Builder#setRetriable(boolean)}
	 */
	@Override
	public boolean isRetriable() {
		if (this.verb == Verb.GET && isRetriable == null) {
			return true;
		}
		return super.isRetriable();
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	public static Builder newBuilder(HttpRequest toCopy) {
		return new Builder(toCopy);
	}

	/**
	 * 返回替换URI的新HttpRequest实例。
	 */
	@Override
	public HttpRequest replaceUri(URI newURI) {
		return (new Builder()).uri(newURI).headers(this.httpHeaders).queryParams(this.queryParams)
				.setRetriable(this.isRetriable()).verb(this.getVerb()).entity(this.entity).build();
	}
}
