package com.jjkr.PetStoreFullStack.REST.Controller;

import com.jjkr.PetStoreFullStack.REST.Entity.Admin;
import com.jjkr.PetStoreFullStack.REST.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService impl;

    @GetMapping("/admins")
    public List<Admin> getAllAdmins(){
        return this.impl.getAllAdmins();
    }
    @GetMapping("/admins/{id}")
    public Admin getAdminById(@PathVariable String id){
        return this.impl.getAdminById(Integer.parseInt(id));
    }
    public Admin getAdminByInfo(String email, String pass){
        return this.impl.getAdminByInfo(email, pass);
    }
    @PutMapping("/admins")
    public Admin updateAdmin(@RequestBody Admin admin){
        return this.impl.updateAdmin(admin);
    }
    @PostMapping("/admins")
    public Admin addNewAdmin(@RequestBody Admin admin){
        return this.impl.addNewAdmin(admin);
    }
    @DeleteMapping("/admins/{id}")
    public String deleteAdminById(@PathVariable String id){
        return this.impl.deleteAdminById(Integer.parseInt(id));
    }
}
