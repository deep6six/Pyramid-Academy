package com.jjkr.PetStoreFullStack.REST.Service;


import com.jjkr.PetStoreFullStack.REST.Dao.CustomerDao;
import com.jjkr.PetStoreFullStack.REST.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServImpl {
    @Autowired
    private CustomerDao dao;

    public List<Customer> getAllCustomers(){
        return this.dao.findAll();
    }
    public Customer getCustomerById(int id){
        Optional<Customer> n = this.dao.findById(id);
        Customer cust = null;
        if (n.isPresent()){
            cust = n.get();
        }
        else {
            throw new RuntimeException("Cant find Customer with that ID");
        }
        return cust;
    }
    public Customer changeCustomer(Customer customer){
        return this.dao.save(customer);
    }
    public Customer addNewCustomer(Customer customer ){
        return this.dao.save(customer);
    }
    public String deleteCustomer(int id){
        this.dao.deleteById(id);
        return "Deleted Successfully";
    }
}
