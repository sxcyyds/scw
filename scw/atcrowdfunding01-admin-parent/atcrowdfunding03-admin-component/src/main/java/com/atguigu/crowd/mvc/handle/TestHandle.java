package com.atguigu.crowd.mvc.handle;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.utils.CrowdUtil;
import com.atguigu.crowd.utils.ResultEntity;
import com.fasterxml.jackson.databind.Module;


@Controller
public class TestHandle {
	private static final int List = 0;
	@Autowired
	private AdminService adminService;
	
	Logger logger = LoggerFactory.getLogger(TestHandle.class);

	

	
	@RequestMapping("/test/ssm.html")
	public String testSSMString(Model model,HttpServletRequest req) {
		List<Admin> all = adminService.getAll();
		model.addAttribute("all",all);
		logger.info("是不是ajax请求"+CrowdUtil.judgeRequestType(req));
		System.out.println(10/0);
		
		
		
		return "target";
	}
	
	@ResponseBody
	@RequestMapping(value="/send/array.html",method = RequestMethod.POST)
	public String testAjax(@RequestParam("array[]") List<Integer> array) {
		
		for (Integer i : array) {
			System.out.println(i);
		}
		
		return "target";
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/send/arraythree.html",method = RequestMethod.POST)
	public String testAjaxthree(@RequestBody List<Integer> array) {
		Logger logger = LoggerFactory.getLogger(this.getClass());
		for (Integer i : array) {
			logger.info("number="+i);
		}
		
		return "target";
		
	}
	
	@ResponseBody
	@RequestMapping("/result.json")
	public ResultEntity<List<Admin>>  testgetAll(){
		List<Admin> all = adminService.getAll();
		ResultEntity<List<Admin>> successWithData = ResultEntity.successWithData(all);
		System.out.println(successWithData);
		return successWithData;
		
		
	}

}
