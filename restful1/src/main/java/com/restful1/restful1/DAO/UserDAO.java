package com.restful1.restful1.DAO;

import com.restful1.restful1.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {}
