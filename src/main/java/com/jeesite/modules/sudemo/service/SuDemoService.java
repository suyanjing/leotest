/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sudemo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.sudemo.entity.SuDemo;
import com.jeesite.modules.sudemo.dao.SuDemoDao;

/**
 * 小样Service
 * @author syj
 * @version 2018-05-31
 */
@Service
@Transactional(readOnly=true)
public class SuDemoService extends CrudService<SuDemoDao, SuDemo> {
	
	/**
	 * 获取单条数据
	 * @param suDemo
	 * @return
	 */
	@Override
	public SuDemo get(SuDemo suDemo) {
		return super.get(suDemo);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param suDemo
	 * @return
	 */
	@Override
	public Page<SuDemo> findPage(Page<SuDemo> page, SuDemo suDemo) {
		return super.findPage(page, suDemo);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param suDemo
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SuDemo suDemo) {
		super.save(suDemo);
	}
	
	/**
	 * 更新状态
	 * @param suDemo
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(SuDemo suDemo) {
		super.updateStatus(suDemo);
	}
	
	/**
	 * 删除数据
	 * @param suDemo
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(SuDemo suDemo) {
		super.delete(suDemo);
	}
	
}