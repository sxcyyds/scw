 package com.atguigu.crowd.mvc.config;

import java.io.IOException;

import javax.security.auth.login.FailedLoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.crowd.exception.LoginFailedException;
import com.atguigu.crowd.utils.CrowdConstant;
import com.atguigu.crowd.utils.CrowdUtil;
import com.atguigu.crowd.utils.ResultEntity;
import com.fasterxml.jackson.databind.Module;
import com.google.gson.Gson;

//@ControllerAdvice表示当前类是一个基于注解的异常处理类
@ControllerAdvice
public class CrowdExceptionReslover {
	//@ExceptionHandler 将一个具体的异常类型和具体的方法关联在一起
	@ExceptionHandler(value=NullPointerException.class)
	public ModelAndView testAndView(NullPointerException exception,HttpServletRequest req,HttpServletResponse res) throws IOException {
		//1、判断当前的请求类型
		boolean judgeRequestType = CrowdUtil.judgeRequestType(req);
		if(judgeRequestType) {
			//2、创建ResultEntity对象
			ResultEntity<Object> failed = ResultEntity.failed(exception.getMessage());
			Gson gson = new Gson();
			//3、将ResultEntity对象转换为JSON字符转
			String json = gson.toJson(failed);
			//4、将JSON字符传返回给浏览器
			res.getWriter().write(json);
			return null;
			
		}
		//如果不是ajax请求则创建moduleandview对象
		ModelAndView modelAndView1 = new ModelAndView();
		modelAndView1.addObject("exception",exception);
		modelAndView1.setViewName("system-error");
		
		return modelAndView1;
		
		
	}
	
	
	
	
	@ExceptionHandler(value=ArithmeticException.class)
	public ModelAndView testAndView(ArithmeticException exception,HttpServletRequest req,HttpServletResponse res) throws IOException {
//		//1、判断当前的请求类型
//		boolean judgeRequestType = CrowdUtil.judgeRequestType(req);
//		if(judgeRequestType) {
//			//2、创建ResultEntity对象
//			ResultEntity<Object> failed = ResultEntity.failed(exception.getMessage());
//			Gson gson = new Gson();
//			//3、将ResultEntity对象转换为JSON字符转
//			String json = gson.toJson(failed);
//			//4、将JSON字符传返回给浏览器
//			res.getWriter().write(json);
//			return null;
//			
//		}
//		//如果不是ajax请求则创建moduleandview对象
//		ModelAndView modelAndView1 = new ModelAndView();
//		modelAndView1.addObject("exception",exception);
//		modelAndView1.setViewName("system-error");
//		
//		return modelAndView1;
		String viewName="system-error";
		return commons(viewName, exception, req, res);
		
	}
	
	
//	代码重复量过多，抽出公共部分
	public ModelAndView commons(String viewName,Exception exception,HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		//1、判断当前的请求类型
				boolean judgeRequestType = CrowdUtil.judgeRequestType(req);
				if(judgeRequestType) {
					//2、创建ResultEntity对象
					ResultEntity<Object> failed = ResultEntity.failed(exception.getMessage());
					Gson gson = new Gson();
					//3、将ResultEntity对象转换为JSON字符转
					String json = gson.toJson(failed);
					//4、将JSON字符传返回给浏览器
					res.getWriter().write(json);
					return null;
					
				}
				//如果不是ajax请求则创建moduleandview对象
				ModelAndView modelAndView1 = new ModelAndView();
				modelAndView1.addObject(CrowdConstant.ATTR_NAME_EXCEPTION,exception);
				modelAndView1.setViewName(viewName);
				
				return modelAndView1;
				
		

		
		
	}
	
	@ExceptionHandler(value=LoginFailedException.class)
	public ModelAndView resolveLoginFailedException(LoginFailedException exception,HttpServletRequest req,HttpServletResponse res) throws IOException {
		//1、判断当前的请求类型
		boolean judgeRequestType = CrowdUtil.judgeRequestType(req);
		if(judgeRequestType) {
			//2、创建ResultEntity对象
			ResultEntity<Object> failed = ResultEntity.failed(exception.getMessage());
			Gson gson = new Gson();
			//3、将ResultEntity对象转换为JSON字符转
			String json = gson.toJson(failed);
			//4、将JSON字符传返回给浏览器
			res.getWriter().write(json);
			return null;
			
		}
		//如果不是ajax请求则创建moduleandview对象
		ModelAndView modelAndView1 = new ModelAndView();
		modelAndView1.addObject("exception",exception);
		String view_name="admin-login";
		modelAndView1.setViewName(view_name);
		
		return modelAndView1;
		
		
	}

}
