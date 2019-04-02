package org.fhfirehuo.subvert.client.http;

import java.util.HashMap;
import java.util.Map;

/**
 * 不区分大小写的Header实现
 * 
 * @author liuyi27
 *
 */
public class CaseInsensitiveHttpHeaders implements HttpHeaders {

	Map<String, String> headers = new HashMap<>();

	@Override
	public String getValue(String headerName) {
		return headers.get(headerName);
	}

	@Override
	public Map<String, String> getAllHeaders() {
		return headers;
	}

	@Override
	public boolean containsHeader(String name) {
		return headers.containsKey(name.toLowerCase());
	}

	public void addHeader(String name, String value) {
        if (headers.containsKey(name)) {
            return;
        }
        headers.put(name, value);
    }

}
