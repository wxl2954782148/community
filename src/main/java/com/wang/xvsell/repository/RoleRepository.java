package com.wang.xvsell.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wang.xvsell.daomain.manytomany.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
