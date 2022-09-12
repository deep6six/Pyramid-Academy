package com.jjkr.PetStoreFullStack.REST.Service;

import com.jjkr.PetStoreFullStack.REST.Dao.ItemDao;
import com.jjkr.PetStoreFullStack.REST.Entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl {
    @Autowired
    private ItemDao dao;

    public List<Item> getAllItems(){
        return this.dao.findAll();
    }
    public Item getItemById(int id){
        Optional<Item> n = this.dao.findById(id);
        Item i = null;
        if (n.isPresent()){
            i = n.get();
        }
        else {
            throw new RuntimeException("Cant find Item with that ID");
        }
        return i;
    }
    public Item changeItem(Item item){
        return this.dao.save(item);
    }
    public Item addNewItem(Item item ){
        return this.dao.save(item);
    }
    public String deleteItem(int id){
        this.dao.deleteById(id);
        return "Item with ID: " + id + " Deleted Successful";
    }
}
