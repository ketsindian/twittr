package com.twittr.app.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twittr.app.model.Admin;
import com.twittr.app.model.AdminActivity;
import com.twittr.app.model.AdminActivityDAO;
import com.twittr.app.repository.AdminActivityRepository;
import com.twittr.app.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminActivityService implements IAdminActivityService{
    private final AdminActivityRepository adminActivityRepository;

    @Autowired
    public AdminActivityService(AdminActivityRepository adminActivityRepository) {
        this.adminActivityRepository = adminActivityRepository;
    }


    @Override
    public AdminActivityDAO postAdminActivityRequest(AdminActivity adminActivity,Long adminId){
        Admin admin=new Admin();
        admin.setAdmin_id(adminId);
        adminActivity.setAdmin(admin);
        return adminActivityRepository.save(this.convertAdminActDtoToAdminAct(adminActivity));
    }

    @Override
    public List<AdminActivityDAO> getAdminActivities(Long adminId) {
        return adminActivityRepository.findAllByAdminId(adminId);
    }

    private AdminActivityDAO convertAdminActDtoToAdminAct(AdminActivity adminActivity){
        AdminActivityDAO adminActivityDAO=new AdminActivityDAO();
        adminActivityDAO.setActivity_id(adminActivity.getActivity_id());
        adminActivityDAO.setAdmin(adminActivity.getAdmin());
        adminActivityDAO.setCreated_ts(adminActivity.getCreated_ts());
        adminActivityDAO.setRequest_approved(adminActivity.isRequest_approved());
        GsonBuilder gsonBuilder=new GsonBuilder();
        adminActivityDAO.setRequest_data(gsonBuilder.create().toJson(adminActivity.getActivity_request_data()));
        return adminActivityDAO;
    }
}
