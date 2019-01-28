/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sudemo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.sudemo.entity.SuDemo;
import com.jeesite.modules.sudemo.service.SuDemoService;

/**
 * 小样Controller
 * @author syj
 * @version 2018-05-31
 */
@Controller
@RequestMapping(value = "${adminPath}/sudemo/suDemo")
public class SuDemoController extends BaseController {

	@Autowired
	private SuDemoService suDemoService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SuDemo get(String id, boolean isNewRecord) {
		return suDemoService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("sudemo:suDemo:view")
	@RequestMapping(value = {"list", ""})
	public String list(SuDemo suDemo, Model model) {
		model.addAttribute("suDemo", suDemo);
		return "modules/sudemo/suDemoList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("sudemo:suDemo:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<SuDemo> listData(SuDemo suDemo, HttpServletRequest request, HttpServletResponse response) {
		Page<SuDemo> page = suDemoService.findPage(new Page<SuDemo>(request, response), suDemo); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("sudemo:suDemo:view")
	@RequestMapping(value = "form")
	public String form(SuDemo suDemo, Model model) {
		model.addAttribute("suDemo", suDemo);
		return "modules/sudemo/suDemoForm";
	}

	/**
	 * 保存小样
	 */
	@RequiresPermissions("sudemo:suDemo:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated SuDemo suDemo) {
		suDemoService.save(suDemo);
		return renderResult(Global.TRUE, "保存小样成功！");
	}
	
	/**
	 * 删除小样
	 */
	@RequiresPermissions("sudemo:suDemo:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(SuDemo suDemo) {
		suDemoService.delete(suDemo);
		return renderResult(Global.TRUE, "删除小样成功！");
	}
	
}