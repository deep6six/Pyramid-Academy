package com.jjkr.PetStoreFullStack.REST.Dao;

import com.jjkr.PetStoreFullStack.REST.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<Item, Integer> {
}
