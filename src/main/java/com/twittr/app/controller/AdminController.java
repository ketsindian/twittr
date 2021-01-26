package com.twittr.app.controller;

import com.twittr.app.model.Admin;
import com.twittr.app.model.AdminActivity;
import com.twittr.app.model.AdminActivityDAO;
import com.twittr.app.model.Tweet;
import com.twittr.app.services.IAdminActivityService;
import com.twittr.app.services.ITweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AdminController {

    private final IAdminActivityService adminActivityService;

    @Autowired
    public AdminController(IAdminActivityService adminActivityService) {
        this.adminActivityService = adminActivityService;
    }

//    @GetMapping("/user/{userId}/tweets")
//    public List<Tweet> getTweetsForUser(@Validated @PathVariable long userId) {
//        return tweetService.getTweetByUser(userId);
//    }


    @GetMapping("/admin/{adminId}/requests")
    public List<AdminActivityDAO> getAdminActivityRequest(@Validated @PathVariable long adminId) {
        return adminActivityService.getAdminActivities(adminId);
    }

    @PostMapping("/admin/{adminId}/request")
    public AdminActivityDAO postAdminActivityRequest(@Validated @RequestBody AdminActivity adminActivity, @Validated @PathVariable long adminId) {
        return adminActivityService.postAdminActivityRequest(adminActivity,adminId);
    }


}
