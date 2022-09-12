package com.jjkr.PetStoreFullStack.REST.Service;

import com.jjkr.PetStoreFullStack.REST.Dao.AnimalDao;
import com.jjkr.PetStoreFullStack.REST.Entity.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl {
    @Autowired
    private AnimalDao dao;

    public List<Animal> getAllAnimals(){
        return this.dao.findAll();
    }
    public Animal getAnimalById(int id){
        Optional<Animal> opt = this.dao.findById(id);
        Animal a = null;
        if (opt.isPresent()){
            a = opt.get();
        }
        else {
            throw new RuntimeException("No Animal with that ID");
        }
        return a;
    }
    public Animal updateAnimal(Animal animal){
        return this.dao.save(animal);
    }
    public Animal addNewAnimal(Animal animal){
        return this.dao.save(animal);
    }
    public String deleteAnimalById(int id){
        this.dao.deleteById(id);
        return "Animal with ID: " + id + ", Deleted Successful";
    }
}
