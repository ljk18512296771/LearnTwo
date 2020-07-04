package com.jt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;

@SpringBootTest//将这个类交给spring来管理
public class TestMybatis {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void findAll() {

		List<User> findAll = userMapper.findAll();
		System.out.println(findAll);
	}

	@Test
	public void select1() {

		List<User> findAll = userMapper.selectList(null);
		System.out.println(findAll);
	}
	/**
	 * 新增操作
	 */
	@Test
	public void insert() {

		User user = new User();
		user.setName("李建坤给力")
		.setAge(111)
		.setSex("男");

		int insert = userMapper.insert(user);
		System.out.println(insert);
	}

	/**
	 * 案例1:查询id为52的信息
	 * 参数就充当了where的条件
	 */
	@Test
	public void select() {

		int id=52;
		User xinxi = userMapper.selectById(id);
		System.out.println(xinxi);
	}

	/**
	 * 查询name=孙尚香 sex= 女性的拥护
	 * queryWrapper是一个条件构造器,用于拼接where条件
	 * 逻辑运算符 =  eq
	 * > gt
	 * < lt
	 * >= ge
	 * <= le
	 * 利用对象只能使用等号的操作,而条件构造器可以使用其他的操作
	 */
	@Test
	public void select2() {
		User user = new User();
		user.setName("孙尚香")
		.setSex("女");
		//根据对象中不为null的元素拼接where条件,默认条件下使用and连接符

		QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
		List<User> selectList = userMapper.selectList(queryWrapper);
		System.out.println(selectList);

		//方法2,利用条件构造器构建where条件
		QueryWrapper<User> queryWrapper2 = new QueryWrapper<User>(); 
		queryWrapper2.eq("name","孙尚香")
		.eq("sex", "女");
		List<User> selectList2 = userMapper.selectList(queryWrapper2);
		System.out.println(selectList2);
	}

	
	
	/**
	 * 查询id=1,3,6的用户
	 */
	@Test
	public void select4() {
	
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(6);
		
		List<User> selectBatchIds = userMapper.selectBatchIds(list);
		System.out.println(selectBatchIds);
		
		QueryWrapper<User> q= new QueryWrapper<User>();
		q.in("id", 1,3,4,5);
		userMapper.selectList(q);
		System.out.println(q);
	}
	
	/**
	 * 查询id=1,3,6的用户
	 */
	@Test
	public void select5() {
	
	
		QueryWrapper<User> q= new QueryWrapper<User>();
		q.between("字段","值1","值2");
		q.like("name","精");//包含精的
		q.likeRight("name","精");//以精开头的
		q.likeRight("name","精");//以精开头的
		q.likeLeft("name","精");//以精结尾的
		q.likeLeft("name","精");//以精结尾的
		//q.groupBy("name");//分组查询
		
		System.out.println(q);
	}
	
	
	
}
