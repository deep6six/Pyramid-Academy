package com.jjkr.PetStoreFullStack.REST.Dao;

import com.jjkr.PetStoreFullStack.REST.Entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalDao extends JpaRepository<Animal, Integer> {
}
