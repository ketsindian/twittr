package com.twittr.app.repository;

import com.twittr.app.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet,Long> {

    @Query("select tw from Tweet tw where tw.user.user_id = ?1 ")
    public List<Tweet> getAllTweetsByUser(long user_id);

}
