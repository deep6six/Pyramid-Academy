package com.jjkr.PetStoreFullStack.REST.Controller;

import com.jjkr.PetStoreFullStack.REST.Entity.Item;
import com.jjkr.PetStoreFullStack.REST.Service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemServiceImpl impl;

//    @RequestMapping("/")
//    public String home(){
//        return "<html><h1>Home Page</h1></html>";
//    }

    @GetMapping("/items")
    public List<Item> getAllItems(){
        return this.impl.getAllItems();
    }
    @GetMapping("/items/{id}")
    public Item getItemById(@PathVariable String id){
        return this.impl.getItemById(Integer.parseInt(id));
    }
    @PutMapping("/items")
    public Item changeItem(@RequestBody Item item){
        return this.impl.changeItem(item);
    }
    @PostMapping("/items")
    public Item addNewItem(@RequestBody Item item){
        return this.impl.addNewItem(item);
    }
    @DeleteMapping("/items/{id}")
    public String deleteItemById(@PathVariable String id){
        return this.impl.deleteItem(Integer.parseInt(id));
    }
}
