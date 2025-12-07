package com.Restaurant.service;

import com.Restaurant.model.Admin;
import com.Restaurant.repository.IAdminRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminService {

    @Autowired
    private IAdminRepo adminRepo;

    public Admin addAdmin(Admin admin) {
        if (adminRepo.existsByEmail(admin.getEmail())) {
            log.error("An admin with the email '" + admin.getEmail() + "' already exists.");
            Admin errorAdmin = new Admin();
            Admin.Error error = new Admin.Error("Admin with this email already exists.");
            errorAdmin.setError(error);
            return errorAdmin;
        }
        return adminRepo.save(admin);
    }

    public boolean ifAdminExistOrNot(String email) {
        return adminRepo.existsByEmail(email);
    }
}