package com.jjkr.PetStoreFullStack.REST.Controller;


import com.jjkr.PetStoreFullStack.REST.Entity.Customer;
import com.jjkr.PetStoreFullStack.REST.Service.CustomerServImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerServImpl impl;
    @RequestMapping("/")
    public String home(){
        return "<html><h1>Home Page</h1></html>";
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomer(){
        return this.impl.getAllCustomers();
    }
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable String id){
        return this.impl.getCustomerById(Integer.parseInt(id));
    }
    @PostMapping("/customers")
    public Customer addNewCustomer(@RequestBody Customer customer){
        return this.impl.addNewCustomer(customer);
    }
    @PutMapping("/customers")
    public Customer changeCustomer(@RequestBody Customer customer) {
        return this.impl.changeCustomer(customer);
    }
    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable String id){
        return this.impl.deleteCustomer(Integer.parseInt(id));
    }
}
