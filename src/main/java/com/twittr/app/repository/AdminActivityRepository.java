package com.twittr.app.repository;

import com.twittr.app.model.AdminActivity;
import com.twittr.app.model.AdminActivityDAO;
import com.twittr.app.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface AdminActivityRepository extends JpaRepository<AdminActivityDAO,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE AdminActivityDAO SET request_approved=?2, request_approved_ts=?3 WHERE activity_id=?1")
    public int approveAdminActivity(long activity_id, boolean approve, Date approve_ts);


    @Transactional
    @Modifying
    @Query("UPDATE AdminActivityDAO SET response_data=?2 WHERE activity_id=?1")
    public int updateAdminActivityResponse(long activity_id, String responseData);

    @Query("Select ad from AdminActivityDAO ad WHERE ad.admin.admin_id=?1")
    public List<AdminActivityDAO> findAllByAdminId(long adminId);
}
