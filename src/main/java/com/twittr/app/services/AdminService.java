package com.twittr.app.services;

import com.twittr.app.model.Admin;
import com.twittr.app.repository.AdminRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService{

    private final AdminRepostory adminRepostory;

    @Autowired
    public AdminService(AdminRepostory adminRepostory) {
        this.adminRepostory = adminRepostory;
    }


    @Override
    public Admin createAdmin(Admin admin) {
        return adminRepostory.save(admin);
    }
}
