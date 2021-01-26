package com.twittr.app.commands;

import com.google.gson.Gson;
import com.twittr.app.model.AdminActivityRequest;
import com.twittr.app.model.TWEET_COMMAND_TYPE;
import com.twittr.app.model.Tweet;
import com.twittr.app.repository.AdminActivityRepository;
import com.twittr.app.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadTweetsCommandExecutor extends TweetCommandExecutor {

    private final TweetRepository tweetRepository;
    private final AdminActivityRepository adminActivityRepository;

    @Autowired
    public ReadTweetsCommandExecutor(TweetRepository tweetRepository, AdminActivityRepository adminActivityRepository) {
        this.tweetRepository = tweetRepository;
        this.adminActivityRepository = adminActivityRepository;
    }

    @Override
    public boolean isValid(AdminActivityRequest adminActivityRequest) {
        return adminActivityRequest!=null && adminActivityRequest.getUser()!=null && adminActivityRequest.getUser().getUser_id()!=0;
    }

    @Override
    public void executeCommand(long activityId,AdminActivityRequest data) {
        List<Tweet> tweets=tweetRepository.getAllTweetsByUser(data.getUser().getUser_id());
        adminActivityRepository.updateAdminActivityResponse(activityId,new Gson().toJson(tweets).toString());
    }

    @Override
    public boolean isApplicable(TWEET_COMMAND_TYPE tweet_command_type) {
        return TWEET_COMMAND_TYPE.READ_ALL_USER_TWEETS.equals(tweet_command_type);
    }
}
