package com.lps.pspc.service.impl;

import java.io.InputStream;
import java.net.URI;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.lps.pspc.config.APIConfig;

public class BaseService {
	private APIConfig loginConfig;
	private APIConfig commonConfig;
	
	protected byte[] postForByte(String url, HttpEntity param, String reqContentType) throws Exception {
		byte[] rs = null;
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost req = new HttpPost(url);
		req.setHeader("Content-Type", reqContentType);
		req.setEntity(param);
		CloseableHttpResponse resp = client.execute(req);
		try {
			HttpEntity entity = resp.getEntity();
			if (entity != null) {
				InputStream is = entity.getContent();
				int length = (int) entity.getContentLength();
				rs = new byte[length];
				int flag = 0;
				int a = 0;
				while ((a = is.read(rs, flag, length)) > 0) {
					flag += a;
				}
				is.close();
			}
		} finally {
			resp.close();
			client.close();
		}
		return rs;
	};

	protected String postForString(String url, HttpEntity param, String reqContentType) throws Exception {
		byte[] rs = postForByte(url, param, reqContentType);
		return rs != null ? new String(rs, "utf-8") : "";
	};

	protected JSONObject postForJsonObject(String url, HttpEntity param, String reqContentType) throws Exception {
		String rs = postForString(url, param, reqContentType);
		return "".equals(rs) ? null : JSONObject.fromObject(rs);
	};

	protected JSONArray postForJsonArray(String url, HttpEntity param, String reqContentType) throws Exception {
		String rs = postForString(url, param, reqContentType);
		return "".equals(rs) ? null : JSONArray.fromObject(rs);
	};
	
	protected byte[] getForByte(String url) throws Exception {
		byte[] rs = null;
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet req = new HttpGet(url);
		CloseableHttpResponse resp = client.execute(req);
		try {
			HttpEntity entity = resp.getEntity();
			if (entity != null) {
				InputStream is = entity.getContent();
				int length = (int) entity.getContentLength();
				rs = new byte[length];
				int flag = 0;
				int a = 0;
				while ((a = is.read(rs, flag, length)) > 0) {
					flag += a;
				}
				is.close();
			}
		} finally {
			resp.close();
			client.close();
		}
		return rs;
	};
	
	protected String getForString(String url) throws Exception {
		byte[] rs = getForByte(url);
		return rs != null ? new String(rs, "utf-8") : "";
	};

	protected JSONObject getForJsonObject(String url) throws Exception {
		String rs = getForString(url);
		return "".equals(rs) ? null : JSONObject.fromObject(rs);
	};

	protected JSONArray getForJsonArray(String url) throws Exception {
		String rs = getForString(url);
		return "".equals(rs) ? null : JSONArray.fromObject(rs);
	};
	
	protected byte[] getForByte(URI uri) throws Exception {
		byte[] rs = null;
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet req = new HttpGet(uri);
		CloseableHttpResponse resp = client.execute(req);
		try {
			HttpEntity entity = resp.getEntity();
			if (entity != null) {
				InputStream is = entity.getContent();
				int length = (int) entity.getContentLength();
				rs = new byte[length];
				int flag = 0;
				int a = 0;
				while ((a = is.read(rs, flag, length)) > 0) {
					flag += a;
				}
				is.close();
			}
		} finally {
			resp.close();
			client.close();
		}
		return rs;
	};
	
	protected String getForString(URI uri) throws Exception {
		byte[] rs = getForByte(uri);
		return rs != null ? new String(rs, "utf-8") : "";
	};

	protected JSONObject getForJsonObject(URI uri) throws Exception {
		String rs = getForString(uri);
		return "".equals(rs) ? null : JSONObject.fromObject(rs);
	};

	protected JSONArray getForJsonArray(URI uri) throws Exception {
		String rs = getForString(uri);
		return "".equals(rs) ? null : JSONArray.fromObject(rs);
	};
	
	public APIConfig getLoginConfig() {
		return loginConfig;
	}
	public APIConfig getCommonConfig() {
		return commonConfig;
	}
	@Resource(name="loginConfig")
	public void setLoginConfig(APIConfig loginConfig) {
		this.loginConfig = loginConfig;
	}
	@Resource(name="commonConfig")
	public void setCommonConfig(APIConfig commonConfig) {
		this.commonConfig = commonConfig;
	}
}
