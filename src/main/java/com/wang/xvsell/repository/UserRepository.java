package com.wang.xvsell.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.wang.xvsell.daomain.manytomany.User;

public interface UserRepository extends JpaRepository<User, String>{

}
