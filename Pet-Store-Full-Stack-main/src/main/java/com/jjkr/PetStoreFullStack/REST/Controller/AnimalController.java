package com.jjkr.PetStoreFullStack.REST.Controller;

import com.jjkr.PetStoreFullStack.REST.Entity.Animal;
import com.jjkr.PetStoreFullStack.REST.Service.AnimalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {
    @Autowired
    private AnimalServiceImpl impl;

//    @RequestMapping("/")
//    public String home(){
//        return "<html><h1>Home Page</h1></html>";
//    }

    @GetMapping("/animals")
    public List<Animal> getAllAnimals(){
        return this.impl.getAllAnimals();
    }
    @GetMapping("/animals/{id}")
    public Animal getAnimalById(@PathVariable String id){
        return this.impl.getAnimalById(Integer.parseInt(id));
    }
    @PutMapping("/animals")
    public Animal updateAnimal(@RequestBody Animal animal){
        return this.impl.updateAnimal(animal);
    }
    @PostMapping("/animals")
    public Animal addNewAnimal(@RequestBody Animal animal){
        return this.impl.addNewAnimal(animal);
    }
    @DeleteMapping("/animals/{id}")
    public String deleteAnimalById(@PathVariable String id){
        return this.impl.deleteAnimalById(Integer.parseInt(id));
    }
}
