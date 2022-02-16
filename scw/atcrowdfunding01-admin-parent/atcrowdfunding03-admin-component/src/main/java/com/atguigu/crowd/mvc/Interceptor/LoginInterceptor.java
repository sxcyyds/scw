package com.atguigu.crowd.mvc.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.druid.support.spring.mvc.StatHandlerInterceptor;
import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.exception.AccessForbiddenException;
import com.atguigu.crowd.utils.CrowdConstant;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;

public class LoginInterceptor  extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//1、通过request对象获取Session对象
		HttpSession session = request.getSession();
		//2、尝试从session中获取Admin对象
		Admin admin=(Admin)session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN);
		// 3、判断admin对象是否为空
		if(admin == null) {
			 //4 、抛出异常
			throw new  AccessForbiddenException(CrowdConstant.MESSAGE_ACCESS_FORBIDEN);
		}
		//5、 如果Admin不为空，则返回true
		return true;
	}
	

}
