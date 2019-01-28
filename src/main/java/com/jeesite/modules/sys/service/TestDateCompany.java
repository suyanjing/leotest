package com.jeesite.modules.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.sys.dao.CompanyDao;
import com.jeesite.modules.sys.entity.Company;

@Service
@Transactional(readOnly=true)
public class TestDateCompany extends CrudService<CompanyDao, Company>{
	
	@Autowired
	private CompanyDao companyDao;
	
	/**
	 * 查询分页Company
	 */
	public Page<Company> findPage(Page<Company> page,Company company){
		return super.findPage(page, company);
	}
	
	
	
}
