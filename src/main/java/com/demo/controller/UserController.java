package com.demo.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.support.json.JSONUtils;
import com.demo.dao.UserDao;
import com.demo.model.User;

/**
 * 用户控制器
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserDao userDao;

    @RequestMapping("/view")
    public String view() {
        return "main/login";
    }

    @RequestMapping("/indexview")
    public String index() {
        return "main/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(HttpServletRequest request,  
    		HttpServletResponse response) throws Exception{
        try{
        	Map<String, Object> map = new HashMap<String, Object>();
        	map.put("test", "first request");
        	JSONObject json = new JSONObject();
        	json.put("code", 0);
        	json.put("data", map);


        	request.setCharacterEncoding("UTF-8");
        	response.setContentType("text/html;charset=utf-8");
        	PrintWriter writer = response.getWriter();
        	writer.write(json.toString());
        	writer.flush();
        	writer.close();
        } catch (Exception e){
            e.printStackTrace();	
        }
    }
}