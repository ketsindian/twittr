package com.twittr.app.services;

import com.twittr.app.model.Admin;
import com.twittr.app.model.AdminActivity;
import com.twittr.app.model.AdminActivityDAO;
import com.twittr.app.model.Approve;

import java.util.List;

public interface ISuperAdminService {

    public List<AdminActivity> getAdminActivities();

    public AdminActivityDAO approveAdminActivity(Approve approve, long activityId);
}
