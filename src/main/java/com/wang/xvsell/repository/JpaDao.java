//package com.wang.xvsell.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//
//import com.wang.xvsell.daomain.Jpa;
///**
// * 
//     @Modifying注解
//　　　　1、在@Query注解中编写JPQL实现DELETE和UPDATE操作的时候必须加上@modifying注解，以通知Spring Data 这是一个DELETE或UPDATE操作。
//　　　　2、UPDATE或者DELETE操作需要使用事务，此时需要 定义Service层，在Service层的方法上添加事务操作。
//　　　　3、注意JPQL不支持INSERT操作。　
// *@Query当设置nativeQuery=true即可以使用原生SQL进行查询
// *
// *@Query进行查询，返回值为List
// *增删除改返回值为int
// *
// */
//public interface JpaDao extends JpaRepository<Jpa, Integer>{
//	@Modifying
//	@Query(value="INSERT INTO Jpa (user_naem,password) VALUES (?1,?2)",nativeQuery = true)
//	int addJpa(String userNaem,String password);
//	
//	@Query(value="select * from Jpa",nativeQuery = true)
//	List<Jpa> findAll();
//}
