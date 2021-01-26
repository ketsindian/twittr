package com.twittr.app.controller;

import com.twittr.app.model.Admin;
import com.twittr.app.model.AdminActivity;
import com.twittr.app.model.AdminActivityDAO;
import com.twittr.app.model.Approve;
import com.twittr.app.services.IAdminActivityService;
import com.twittr.app.services.IAdminService;
import com.twittr.app.services.ISuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class SuperAdminController {
    private final IAdminActivityService adminActivityService;
    private final IAdminService adminService;
    private final ISuperAdminService superAdminService;

    @Autowired
    public SuperAdminController(IAdminActivityService adminActivityService, IAdminService adminService, ISuperAdminService superAdminService) {
        this.adminActivityService = adminActivityService;
        this.adminService = adminService;
        this.superAdminService = superAdminService;
    }

    @PostMapping("/superadmin/admin")
    public Admin createAdmin(@Validated @RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    @GetMapping("/superadmin/activities")
    public List<AdminActivity> getAdminActivity() {
        return superAdminService.getAdminActivities();
    }

    @PatchMapping("/superadmin/activity/{activityId}")
    public AdminActivityDAO approveActivity(@Validated @RequestBody Approve approve, @Validated @PathVariable long  activityId) {
        return superAdminService.approveAdminActivity(approve,activityId);
    }
}
