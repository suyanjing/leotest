/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.student.student.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 学生信息Entity
 * @author Leo
 * @version 2019-01-24
 */
@Table(name="${_prefix}student", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="student_name", attrName="studentName", label="学生姓名", queryType=QueryType.LIKE),
		@Column(name="student_phone", attrName="studentPhone", label="学生电话"),
		@Column(name="parents_name", attrName="parentsName", label="家长姓名", queryType=QueryType.LIKE),
		@Column(name="parents_phone", attrName="parentsPhone", label="家长电话"),
		@Column(name="student_school", attrName="studentSchool", label="就读学校", queryType=QueryType.LIKE),
		@Column(name="age", attrName="age", label="年龄"),
		@Column(name="startdate", attrName="startdate", label="学期开始时间"),
		@Column(name="enddate", attrName="enddate", label="学期结束时间"),
		@Column(name="schooling", attrName="schooling", label="学费"),
		@Column(name="remark", attrName="remark", label="备注"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class Student extends DataEntity<Student> {
	
	private static final long serialVersionUID = 1L;
	private String studentName;		// 学生姓名
	private String studentPhone;		// 学生电话
	private String parentsName;		// 家长姓名
	private String parentsPhone;		// 家长电话
	private String studentSchool;		// 就读学校
	private String age;		// 年龄
	private Date startdate;		// 学期开始时间
	private Date enddate;		// 学期结束时间
	private Double schooling;		// 学费
	private String remark;		// 备注
	
	public Student() {
		this(null);
	}

	public Student(String id){
		super(id);
	}
	
	@NotBlank(message="学生姓名不能为空")
	@Length(min=0, max=200, message="学生姓名长度不能超过 200 个字符")
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	@Length(min=0, max=255, message="学生电话长度不能超过 255 个字符")
	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	
	@NotBlank(message="家长姓名不能为空")
	@Length(min=0, max=200, message="家长姓名长度不能超过 200 个字符")
	public String getParentsName() {
		return parentsName;
	}

	public void setParentsName(String parentsName) {
		this.parentsName = parentsName;
	}
	
	@NotBlank(message="家长电话不能为空")
	@Length(min=0, max=255, message="家长电话长度不能超过 255 个字符")
	public String getParentsPhone() {
		return parentsPhone;
	}

	public void setParentsPhone(String parentsPhone) {
		this.parentsPhone = parentsPhone;
	}
	
	@Length(min=0, max=200, message="就读学校长度不能超过 200 个字符")
	public String getStudentSchool() {
		return studentSchool;
	}

	public void setStudentSchool(String studentSchool) {
		this.studentSchool = studentSchool;
	}
	
	@Length(min=0, max=255, message="年龄长度不能超过 255 个字符")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="学期开始时间不能为空")
	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="学期结束时间不能为空")
	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	
	public Double getSchooling() {
		return schooling;
	}

	public void setSchooling(Double schooling) {
		this.schooling = schooling;
	}
	
	@Length(min=0, max=2000, message="备注长度不能超过 2000 个字符")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}