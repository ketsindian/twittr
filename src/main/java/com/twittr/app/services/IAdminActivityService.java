package com.twittr.app.services;

import com.twittr.app.model.AdminActivity;
import com.twittr.app.model.AdminActivityDAO;

import java.util.List;

public interface IAdminActivityService {

    public AdminActivityDAO postAdminActivityRequest(AdminActivity adminActivity,Long adminId);

    public List<AdminActivityDAO> getAdminActivities(Long adminId);

}
