package com.lps.pspc.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lps.pspc.service.impl.UserService;

@Controller
@RequestMapping("")
public class MainController {
	@Resource
	private UserService userService;
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String loginGet(HttpServletRequest req, HttpServletResponse resp) {
		if (req.getSession().getAttribute("user") != null) {
			try {
				resp.sendRedirect(req.getScheme()+"://"+req.getServerName()+":"
						+req.getServerPort()+req.getContextPath()+"/main");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "login";
	}
	
	@ResponseBody
	@RequestMapping(value="login", method=RequestMethod.POST)
	public JSONObject loginPost(HttpServletRequest req, HttpServletResponse resp, @RequestBody JSONObject reqBody) throws Exception {
		JSONObject re = new JSONObject();
		re.put("status", false);
		String name = reqBody.has("username") ? reqBody.getString("username") : "";
		String password = reqBody.has("password") ? reqBody.getString("password") : "";
		if (name != null && !"".equals(name) && password != null && !"".equals(password)) {
//			JSONObject user = userService.login(name, password);
			JSONObject user = new JSONObject();
			user.put("name", name);
			if (user != null) {
				re.put("status", true);
				req.getSession().setAttribute("user", user);
			} else {
				re.put("msg", "用户名或密码错误!");
			}
		} else {
			re.put("msg", "用户名和密码不能为空!");
		}
		return re;
	}
	
	@RequestMapping("main")
	public String main(HttpServletRequest req, HttpServletResponse resp) {
		return "main";
	}
	
	@RequestMapping(value="logout")
	public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.getSession().invalidate();
		resp.sendRedirect(req.getScheme()+"://"+req.getServerName()+":"
				+req.getServerPort()+req.getContextPath()+"/login");
	}
}
