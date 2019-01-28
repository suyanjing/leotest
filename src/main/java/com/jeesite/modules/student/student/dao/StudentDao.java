/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.student.student.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.student.student.entity.Student;

/**
 * 学生信息DAO接口
 * @author Leo
 * @version 2019-01-24
 */
@MyBatisDao
public interface StudentDao extends CrudDao<Student> {
	
}