package com.pactera.weather.logging;

import java.io.IOException;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import com.pactera.weather.util.BufferingClientHttpResponseWrapper;

public class HttpRequestInterceptor implements ClientHttpRequestInterceptor {
	private static Logger logger = LoggerFactory.getLogger(HttpRequestInterceptor.class);

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		logRequestDetails(request);
		
		ClientHttpResponse clientResponse = execution.execute(request, body);
		final ClientHttpResponse response = new BufferingClientHttpResponseWrapper(clientResponse);
		
		logResponseDetails(response);
		
		return response;
	}

	private void logRequestDetails(HttpRequest request) {
		logger.info("================request begin================");
		logger.info("Headers: {}", request.getHeaders());
		logger.info("Request Method: {}", request.getMethod());
		logger.info("Request URI: {}", request.getURI());
		logger.info("================request end================");
    }
	
	private void logResponseDetails(ClientHttpResponse response) throws IOException {
		String responseBody = StreamUtils.copyToString(response.getBody(), Charset.defaultCharset());
		
		logger.info("================response begin================");
		logger.info("Status code  : {}", response.getStatusCode());
		logger.info("Status text  : {}", response.getStatusText());
		logger.info("Headers      : {}", response.getHeaders());
		logger.info("Response body: {}", responseBody);
        logger.info("================response end================");
	}
}
