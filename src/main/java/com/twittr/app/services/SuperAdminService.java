package com.twittr.app.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twittr.app.commands.TweetCommandExecutor;
import com.twittr.app.model.AdminActivity;
import com.twittr.app.model.AdminActivityDAO;
import com.twittr.app.model.AdminActivityRequest;
import com.twittr.app.model.Approve;
import com.twittr.app.repository.AdminActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class  SuperAdminService implements  ISuperAdminService{
    private final AdminActivityRepository adminActivityRepository;
    private final List<TweetCommandExecutor> tweetCommandExecutorsList;

    @Autowired
    public SuperAdminService(AdminActivityRepository adminActivityRepository, List<TweetCommandExecutor> tweetCommandExecutorsList) {
        this.adminActivityRepository = adminActivityRepository;
        this.tweetCommandExecutorsList = tweetCommandExecutorsList;
    }

    @Override
    public List<AdminActivity> getAdminActivities() {
        List<AdminActivity> adminActivities = new ArrayList<>();
        adminActivityRepository.findAll().forEach(adminActivityDAO -> {
            AdminActivity adminActivity=new AdminActivity();
            adminActivity.setAdmin(adminActivityDAO.getAdmin());
//            adminActivity.setActivity_request_data();
            adminActivity.setActivity_id(adminActivityDAO.getActivity_id());
            adminActivity.setCreated_ts(adminActivityDAO.getCreated_ts());
            adminActivity.setRequest_approved(adminActivityDAO.isRequest_approved());
            adminActivity.setRequest_approved_ts(adminActivityDAO.getRequest_approved_ts());
            adminActivity.setRequest_data(adminActivityDAO.getRequest_data());
            adminActivity.setResponse_data(adminActivityDAO.getResponse_data());
            adminActivities.add(adminActivity);
        });
        return adminActivities;
    }

    @Override
    public AdminActivityDAO approveAdminActivity(Approve approve, long activityId) {
        adminActivityRepository.approveAdminActivity(activityId,approve.isApprove(), Date.valueOf(LocalDate.now()));
        AdminActivityDAO adminActivityDAO=adminActivityRepository.getOne(activityId);
        AdminActivityRequest adminActivityRequest=new Gson().fromJson(adminActivityDAO.getRequest_data(), AdminActivityRequest.class);
        for (TweetCommandExecutor tweetCommandExecutor : tweetCommandExecutorsList) {
            if (tweetCommandExecutor.isApplicable(adminActivityRequest.getActivity_type())) {
                tweetCommandExecutor.execute(activityId,adminActivityRequest);
            }
        }
        return adminActivityRepository.getOne(activityId);
    }
}
