/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sudemo.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.sudemo.entity.SuDemo;

/**
 * 小样DAO接口
 * @author syj
 * @version 2018-05-31
 */
@MyBatisDao
public interface SuDemoDao extends CrudDao<SuDemo> {
	
}