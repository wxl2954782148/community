package com.wang.xvsell.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wang.xvsell.daomain.onetomany.Order;

public interface OrderRepository extends JpaRepository<Order, String>{

}
