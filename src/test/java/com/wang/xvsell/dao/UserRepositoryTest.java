package com.wang.xvsell.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.wang.xvsell.daomain.manytomany.Gender;
import com.wang.xvsell.daomain.manytomany.Role;
import com.wang.xvsell.daomain.manytomany.User;
import com.wang.xvsell.repository.RoleRepository;
import com.wang.xvsell.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * 多对多测试
 *
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	/**
	 * 保存user，role，user_role
	 */
	@Transactional
	@Rollback(false)
	@Test
	public void testSave() {
		User user = new User();
		user.setUserName("laoli");
		
		Role role = new Role();
		role.setRoleName("root");
		
		user.getRoles().add(role);
		role.getUsers().add(user);
		
		userRepository.save(user);
		//roleRepository.save(role);添加级联
	}
	/**
	 * 根据已有role保存user,user_role
	 */
	@Transactional
	@Rollback(false)
	@Test
	public void testSave2() {
		User user = new User();
		user.setUserName("小红");
		
		Role role = roleRepository.getOne(3);
		Role role2 = roleRepository.getOne(2);
		
		//user.getRoles().add(role);
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		roles.add(role2);
		
		user.setRoles(roles);
		userRepository.save(user);
	}
	/**
	 * 根据用户id查询用户权限
	 * getOne():延迟加载，用到在查询
	 * findById()立即加载
	 */
	@Test
	@Transactional
	@Rollback(false)
	public void findByid() {
		User user = userRepository.getOne("4028b8006cae2a76016cae2a7d9c0000");
		System.out.println(user.getUserName());
		for(Role roles : user.getRoles()) {
			System.out.println(roles.getRoleName());
		}
	}
	@Test
	public void enumeratedTest() {
		User user = new User();
		user.setUserName("aa");
		user.setGender(Gender.FMAIL);
		userRepository.save(user);
	}
	
	@Test
	public void find() {
		User user = new User();
		user.setGender(Gender.MAIL);
		
		Example<User> e = Example.of(user);
		List<User> list= userRepository.findAll(e);
		for(User users:list) {
			System.out.println(users.getUserName());
		}
	}
	
	@Test
	public void find2() {
		User user = new User();
		user.setGender(Gender.MAIL);
		Example<User> e = Example.of(user);
		List<User> list= userRepository.findAll(e);
		for(User users:list) {
			System.out.println(users.getUserName());
		}
	}@Test
	public void find3() {
		User user = new User();
		user.setGender(Gender.MAIL);
		Example<User> example = Example.of(user);
		Sort sort = new Sort(Direction.ASC, "userId");
		List<User> list= userRepository.findAll(example, sort);
		for(User users:list) {
			System.out.println(users.getUserName());
		}
	}
	
}
