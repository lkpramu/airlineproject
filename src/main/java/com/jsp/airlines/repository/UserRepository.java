package com.jsp.airlines.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.airlines.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
	@Query("SELECT m1 FROM User m1 WHERE m1.mobileNo=:mobileNo AND m1.password=:password")
	List<User> finddByMobileAndPassword(@Param("mobileNo") String mobile,@Param("password") String password);
}
