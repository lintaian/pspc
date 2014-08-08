package com.lps.pspc.service.interfaces;

import net.sf.json.JSONObject;

public interface UserServiceIF {
	public JSONObject login(String name, String pwd) throws Exception;
}
