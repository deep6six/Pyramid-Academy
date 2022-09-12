package com.jjkr.PetStoreFullStack.REST.Dao;

import com.jjkr.PetStoreFullStack.REST.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {
}
