package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName//与表进行关联,如果名称一致,则可以省略不写
public class User {
	//属性一般都与表字段对应
	@TableId(type=IdType.AUTO)//主键的说明
	private Integer id;
	//@TableField(value = "name") 如果属性名称与字段名称一致(包含驼峰规则),则可以省略不写
	private String name;
	private Integer age;
	private String sex;
	
}
