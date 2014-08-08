package com.lps.pspc.config;

import org.springframework.stereotype.Repository;

@Repository
public class APIConfig {
	private String url;
	private String reqContentType = "application/json";
	public String getUrl() {
		return url;
	}
	public String getReqContentType() {
		return reqContentType;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setReqContentType(String reqContentType) {
		this.reqContentType = reqContentType;
	}
}
