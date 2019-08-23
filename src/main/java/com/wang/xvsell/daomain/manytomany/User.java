package com.wang.xvsell.daomain.manytomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid",strategy = "uuid")
	@Column(name="user_id")
	private String userId;
	@Column(name="user_name")
	private String userName;
	
	//@Enumerated:保存枚举对象
	//EnumType.STRING:映射枚举的Name  EnumType.ORDINAL:映射枚举的下标
	@Enumerated(EnumType.STRING)
	@Column(name="user_gender")
	private Gender gender;
	
	@Transient//标注非数据库字段
	private String xxx;
	
	
	@ManyToMany(targetEntity=Role.class,cascade=CascadeType.ALL)
	@JoinTable(name="user_role",//中间表
			joinColumns= {@JoinColumn(name="user_id",referencedColumnName="user_id")},//joinColumns：当前对象在中间表中的外键 name:中间表字段 referencedColumnName：引用的字段
			inverseJoinColumns= {@JoinColumn(name="role_id",referencedColumnName="role_id")}//inverseJoinColumns：目标对象在中间表中的外键
			)
	private Set<Role> roles = new HashSet<>();
}
