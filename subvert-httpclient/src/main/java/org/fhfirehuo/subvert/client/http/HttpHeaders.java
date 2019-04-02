package org.fhfirehuo.subvert.client.http;

import java.util.Map;

public interface HttpHeaders {

	public String getValue(String headerName);

	public Map<String, String> getAllHeaders();

	public boolean containsHeader(String name);
}
