package com.atguigu.crowd.service.api;

import java.util.List;

import com.atguigu.crowd.entity.Admin;
import com.github.pagehelper.PageInfo;

public interface AdminService {
	int  saveAdmin(Admin admin);

	List<Admin> getAll();

	Admin getAdminByLoginAcct(String username, String password);
	
	
	//分页查询
	PageInfo<Admin> getPageInfo(String keyword,Integer pageNum,Integer pageSize);
	

}
