package com.twittr.app.repository;

import com.twittr.app.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepostory extends JpaRepository<Admin, Long> {
}
