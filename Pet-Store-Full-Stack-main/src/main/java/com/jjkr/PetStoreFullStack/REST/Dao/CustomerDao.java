package com.jjkr.PetStoreFullStack.REST.Dao;

import com.jjkr.PetStoreFullStack.REST.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
}
