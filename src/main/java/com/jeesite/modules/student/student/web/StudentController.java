/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.student.student.web;

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
import com.jeesite.modules.student.student.entity.Student;
import com.jeesite.modules.student.student.service.StudentService;

/**
 * 学生信息Controller
 * @author Leo
 * @version 2019-01-24
 */
@Controller
@RequestMapping(value = "${adminPath}/student/student")
public class StudentController extends BaseController {

	@Autowired
	private StudentService studentService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Student get(String id, boolean isNewRecord) {
		return studentService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("student:student:view")
	@RequestMapping(value = {"list", ""})
	public String list(Student student, Model model) {
		model.addAttribute("student", student);
		return "student/student/studentList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("student:student:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Student> listData(Student student, HttpServletRequest request, HttpServletResponse response) {
		Page<Student> page = studentService.findPage(new Page<Student>(request, response), student); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("student:student:view")
	@RequestMapping(value = "form")
	public String form(Student student, Model model) {
		model.addAttribute("student", student);
		return "student/student/studentForm";
	}

	/**
	 * 保存学生信息
	 */
	@RequiresPermissions("student:student:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Student student) {
		studentService.save(student);
		return renderResult(Global.TRUE, "保存学生信息成功！");
	}
	
	/**
	 * 删除学生信息
	 */
	@RequiresPermissions("student:student:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Student student) {
		studentService.delete(student);
		return renderResult(Global.TRUE, "删除学生信息成功！");
	}
	
	@RequiresPermissions("student:student:edit")
	@RequestMapping(value = "sendMsg")
	@ResponseBody
	public String sendMsg(Student student) {
		return renderResult(Global.TRUE, "发送成功！");
	}
	
}