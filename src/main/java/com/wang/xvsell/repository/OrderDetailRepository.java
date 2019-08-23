package com.wang.xvsell.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wang.xvsell.daomain.onetomany.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{

}
