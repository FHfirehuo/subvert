package org.fhfirehuo.subvert.client.http;

import java.io.InputStream;
import java.lang.reflect.Type;

import org.fhfirehuo.subvert.client.IResponse;

public interface HttpResponse extends IResponse {

	/**
     * Get the HTTP status code.
     */
    public int getStatus();
    
    /**
     * Get the reason phrase of HTTP status
     */
    public String getStatusLine();
    
    public HttpHeaders getHttpHeaders();

    public void close();
    
    public InputStream getInputStream();

    public boolean hasEntity();
    
    public <T> T getEntity(Class<T> type) throws Exception;

    public <T> T getEntity(Type type) throws Exception;

}
