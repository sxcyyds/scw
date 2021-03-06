package com.atguigu.crowd.mvc.handle;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.druid.sql.parser.Keywords;
import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.utils.CrowdConstant;
import com.github.pagehelper.PageInfo;

@Controller
public class AdminHandle {
	@Autowired
	private AdminService adminService;

	
	
	@RequestMapping(value="admin/do/logina.html",method = RequestMethod.POST)
	public String  doLogin(@RequestParam("loginAcct") String  username,@RequestParam("userPswd") String password,HttpSession session) {
		Admin admin = adminService.getAdminByLoginAcct(username, password);
		session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN, admin);
		return "redirect:/main.html";
		
	}
	@RequestMapping("/loginout.html")
	public String  loginOut(HttpSession session) {
		 
		
		//强制session失效
		session.invalidate();
		
		return "redirect:/admin/to/login/page.html";
	}
	
	
	
	@RequestMapping("/admin/get/page.html")
	public String getPageInfo(@RequestParam(value="keyword",defaultValue = "") String Keyword, 
								@RequestParam(value="pageNum",defaultValue = "1") Integer pageNum,
										@RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,ModelMap modelMap) {
		PageInfo<Admin> pageInfo = adminService.getPageInfo(Keyword, pageNum, pageSize);
		
		modelMap.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO, pageInfo);
		
			
			
	
		
		return "admin-page";
		
	}
}
