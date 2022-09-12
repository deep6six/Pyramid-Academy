package com.jjkr.PetStoreFullStack.REST.Service;

import com.jjkr.PetStoreFullStack.REST.Dao.AdminDao;
import com.jjkr.PetStoreFullStack.REST.Entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminDao dao;

    public List<Admin> getAllAdmins(){
        return this.dao.findAll();
    }
    public Admin getAdminById(int id){
        Optional<Admin> opt = this.dao.findById(id);
        Admin admin = null;
        if (opt.isPresent()){
            admin = opt.get();
        }
        else {
            throw new RuntimeException("No Admin with that ID");
        }
        return admin;
    }
    public Admin getAdminByInfo(String email, String pass){
        List<Admin> list = this.dao.findAll();
        Admin a = null;
        for (Admin admin: list) {
            if (admin.getEmail().equals(email)){
                if (admin.getPassword().equals(pass)) {
                    a = admin;
                }
                else {
                    throw new RuntimeException("Incorrect Password");
                }
            }
            else {
                throw new RuntimeException("Please Double check the email address");
            }
        }
        return a;
    }
    public Admin updateAdmin(Admin admin){
        return this.dao.save(admin);
    }
    public Admin addNewAdmin(Admin admin){
        return this.dao.save(admin);
    }
    public String deleteAdminById(int id){
        this.dao.deleteById(id);
        return "Admin with ID: " + id + " Deleted Successfully";
    }
}
