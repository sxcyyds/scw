package com.atguigu.crowd.service.impl;

import java.util.List;
import java.util.Objects;

import javax.security.auth.login.FailedLoginException;
import javax.servlet.http.HttpSession;
import javax.swing.text.AbstractDocument.Content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.AdminExample;
import com.atguigu.crowd.entity.AdminExample.Criteria;
import com.atguigu.crowd.exception.LoginFailedException;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.utils.CrowdConstant;
import com.atguigu.crowd.utils.CrowdUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class AnminServiceImpl implements AdminService{
	@Autowired
	private AdminMapper adminMapper;

	public int saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		int i = adminMapper.insert(admin);
		return i;
		
	}

	public List<Admin> getAll() {
		// TODO Auto-generated method stub
		List<Admin> selectByExample = adminMapper.selectByExample(new AdminExample());
		return selectByExample;
	}

	public Admin getAdminByLoginAcct(String username, String password) {
		// 1、根据传递的username查询用户
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andLoginAcctEqualTo(username);
		
		List<Admin> list = adminMapper.selectByExample(example);
		//2 、判断list对象是否为空
		if(list == null || list.size() == 0) {
			throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILD);
		}
		Admin admin = list.get(0);
		
		if(list.size() >1) {
			throw new RuntimeException(CrowdConstant.MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE);
		}
		
		//3、如果admin的对象不为空，则将数据库密码从admin中抽取出来
		String adminDB = admin.getUserPswd();
		
		//4、将传递的密码加密进行对比
		String md5 = CrowdUtil.md5(password);
		if(!Objects.equals(adminDB, md5)) {
			throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILD);
		}
		
			
		return admin;
	}

	public PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize) {
		
		//1、调用PageHelper的静态方法开启分页功能
		Page startPage = PageHelper.startPage(pageNum,pageSize);
		
		//2、执行查询
		List<Admin> list = adminMapper.selectAdminByKeyword(keyword);
		
		//3、封装到PageInfo对象中
		PageInfo pageInfo = new PageInfo(list);
		
		return pageInfo;
	}



	
	

}
