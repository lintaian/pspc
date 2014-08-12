package com.lps.pspc.service.impl;

import java.net.URLEncoder;

import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;

import com.lps.pspc.service.interfaces.UserServiceIF;

@Service("userService")
@Repository
public class UserService extends BaseService implements UserServiceIF {
	@Override
	public JSONObject login(String name, String pwd) throws Exception {
		JSONObject json = new JSONObject();
		json.put("username", name);
		json.put("password", pwd);
		String param = URLEncoder.encode(json.toString(), "utf-8");
		StringEntity entity = new StringEntity(param);
		entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
		JSONObject re = postForJsonObject(getLoginConfig().getUrl(), entity, getLoginConfig().getReqContentType());
		return re;
	}
}
