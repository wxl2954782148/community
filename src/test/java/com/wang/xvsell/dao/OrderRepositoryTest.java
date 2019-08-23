package com.wang.xvsell.dao;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.wang.xvsell.daomain.onetomany.Order;
import com.wang.xvsell.daomain.onetomany.OrderDetail;
import com.wang.xvsell.repository.OrderDetailRepository;
import com.wang.xvsell.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;
/**
 * 一对多测试
 * @author Administrator
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class OrderRepositoryTest {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	/**
	 * 一对多保存
	 */
	@Rollback(false)	//禁止回滚
	@Transactional
	@Test
	public void testSave() {
		//创建订单
		Order order = new Order();
		order.setBuyerName("xiaolei");
		order.setOrderPrice(new BigDecimal("45"));
		//创建订单详情
		OrderDetail detail = new OrderDetail();
		detail.setProductName("辣椒炒肉");
		detail.setProductPrice(new BigDecimal("20"));
		detail.setProductSum((short) 2);
		detail.setOrder(order);
		//创建订单详情
		OrderDetail detai2 = new OrderDetail();
		detai2.setProductName("炒青菜");
		detai2.setProductPrice(new BigDecimal("5"));
		detai2.setProductSum((short) 1);
		detai2.setOrder(order);
		//把订单详情放入订单
		Set<OrderDetail> orderDetails = new HashSet<>();
		orderDetails.add(detail);
		orderDetails.add(detai2);
		
		order.setOrderDetails(orderDetails);
		//保存订单
		orderRepository.save(order);
		//保存订单详情
		orderDetailRepository.saveAll(orderDetails);
	}
	/**
	 * 级联保存：@OneToMany(mappedBy="order",cascade=CascadeType.ALL)
	 * 保存主表的同时保存其他关联表
	 */
	@Rollback(false)	//禁止回滚
	@Transactional
	@Test
	public void testSave2() {
		//创建订单
		Order order = new Order();
		order.setBuyerName("x'x'x'x");
		order.setOrderPrice(new BigDecimal("45"));
		//创建订单详情
		OrderDetail detail = new OrderDetail();
		detail.setProductName("辣椒炒肉");
		detail.setProductPrice(new BigDecimal("20"));
		detail.setProductSum((short) 2);
		detail.setOrder(order);
		//创建订单详情
		OrderDetail detai2 = new OrderDetail();
		detai2.setProductName("炒青菜");
		detai2.setProductPrice(new BigDecimal("5"));
		detai2.setProductSum((short) 1);
		detai2.setOrder(order);
		//把订单详情放入订单
		Set<OrderDetail> orderDetails = new HashSet<>();
		orderDetails.add(detail);
		orderDetails.add(detai2);
		
		order.setOrderDetails(orderDetails);
		//保存订单
		orderRepository.save(order);
		
	}
	/**
	 * 根据id查询
	 */
	@Transactional
	@Test
	public void findByOrderId() {
		Optional<Order> optional = orderRepository.findById("4028b8006cadc61e016cadc625190000");
		Order order = optional.get();
		System.out.println("name:"+order.getBuyerName()+"id:"+order.getOrderId());
		for(OrderDetail o:order.getOrderDetails()) {
			System.out.println("productname"+o.getProductName());
		}
		//log.info("[order]:{}",order);
	}
	/**
	 * 查询所有
	 */
	@Transactional
	@Test
	public void findAll() {
		List<Order> orders = orderRepository.findAll();
		for(Order order : orders) {
			log.info("[order]:{}",order);
		}
	}
}
