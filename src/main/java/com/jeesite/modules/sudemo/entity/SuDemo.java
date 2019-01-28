/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sudemo.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;
import com.jeesite.modules.sys.entity.User;

/**
 * 小样Entity
 * @author syj
 * @version 2018-05-31
 */
@Table(name="${_prefix}demo", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(name="title", attrName="title", label="题目", queryType=QueryType.LIKE),
		@Column(name="content", attrName="content", label="内容"),
		@Column(name="files", attrName="files", label="附件"),
		@Column(includeEntity=DataEntity.class),
	}, joinTable={
		@JoinTable(type=Type.LEFT_JOIN, entity=User.class, attrName="createBy", alias="u5",
			on="u5.user_code = a.create_by", columns={
				@Column(name="user_code", label="用户编码", isPK=true),
				@Column(name="user_name", label="用户名称", isQuery=false),
		}),
		@JoinTable(type=Type.LEFT_JOIN, entity=User.class, attrName="updateBy", alias="u7",
			on="u7.user_code = a.update_by", columns={
				@Column(name="user_code", label="用户编码", isPK=true),
				@Column(name="user_name", label="用户名称", isQuery=false),
		}),
	}, orderBy="a.update_date DESC"
)
public class SuDemo extends DataEntity<SuDemo> {
	
	private static final long serialVersionUID = 1L;
	private String title;		// 题目
	private String content;		// 内容
	private String files;		// 附件
	
	public SuDemo() {
		this(null);
	}

	public SuDemo(String id){
		super(id);
	}
	
	@NotBlank(message="题目不能为空")
	@Length(min=0, max=200, message="题目长度不能超过 200 个字符")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@NotBlank(message="内容不能为空")
	@Length(min=0, max=2000, message="内容长度不能超过 2000 个字符")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@NotBlank(message="附件不能为空")
	@Length(min=0, max=2000, message="附件长度不能超过 2000 个字符")
	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}
	
}