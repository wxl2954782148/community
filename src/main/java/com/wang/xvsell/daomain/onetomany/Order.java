package com.wang.xvsell.daomain.onetomany;

import static org.hamcrest.CoreMatchers.allOf;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
/**
Jpa主键生成策略
  	TABLE, //使用一个额外的数据库表来保存主键
    SEQUENCE,//使用序列的方式，且其底层数据库要支持序列，一般有postgres、Oracle等
    IDENTITY,//主键由数据库生成，一般为自增型主键，支持的有MySql和Sql Server
    AUTO//由程序来决定主键规则
	4种策略只支持数值类型的主键
	如果要使用字符类型的主键，需要JPA使用Hibernate的主键生成策略
 *
 */
@Entity
@Table(name="order_master")
@Getter
@Setter
public class Order {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid",strategy = "uuid")
	@Column(name="order_id")
	private String orderId;
	
	@Column(name="buyer_name")
	private String buyerName;
	
	@Column(name="order_price")
	private BigDecimal orderPrice;
	/**
	 * cascade=CascadeType.ALL 级联操作：通常该实体更新或删除时,其关联的实体也应当被更新删除 
	 * CascadeType.ALL：所有操作
	 * 				DETACH	级联脱管/游离操作 如果你要删除一个实体，但是它有外键无法删除，你就需要这个级联权限了。它会撤销所有相关的外键关联
	 * 				MERGE	更新
	 * 				PERSIST	保存
	 * 				REFRESH 刷新
	 * 				REMOVE	删除
	 */
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL)
	private Set<OrderDetail> orderDetails = new HashSet<>();
}
