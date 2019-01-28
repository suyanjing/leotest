package com.jeesite.modules.sys.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.sys.entity.Company;
import com.jeesite.modules.sys.service.TestDateCompany;

@Controller
@RequestMapping(value="${adminPath}/testCom")
public class CompanyController extends BaseController {
	
	@Autowired
	private TestDateCompany testDateCompany;
	
	@RequestMapping(value="listDate")
	public Page<Company> listDate(Company company,HttpServletRequest request,HttpServletResponse response){
		Page<Company> page=testDateCompany.findPage(new Page<>(request, response), company);
		return page;
	}
	
}
