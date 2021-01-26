package com.twittr.app.commands;

import com.google.gson.Gson;
import com.twittr.app.model.AdminActivityRequest;
import com.twittr.app.model.TWEET_COMMAND_TYPE;
import com.twittr.app.model.Tweet;
import com.twittr.app.repository.AdminActivityRepository;
import com.twittr.app.services.ITweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddTweetCommandExecutor extends TweetCommandExecutor{
    private final ITweetService tweetService;
    private final AdminActivityRepository adminActivityRepository;

    @Autowired
    public AddTweetCommandExecutor(ITweetService tweetService, AdminActivityRepository adminActivityRepository) {
        this.tweetService = tweetService;
        this.adminActivityRepository = adminActivityRepository;
    }


    @Override
    public boolean isValid(AdminActivityRequest adminActivityRequest) {
        return adminActivityRequest!=null && adminActivityRequest.getTweet()!=null;
    }

    @Override
    public void executeCommand(long activityId,AdminActivityRequest activityData) {
        Tweet tweet=tweetService.createTweetForUser(activityData.getTweet(),activityData.getUser().getUser_id());
        adminActivityRepository.updateAdminActivityResponse(activityId,new Gson().toJson(tweet).toString());
    }

    @Override
    public boolean isApplicable(TWEET_COMMAND_TYPE tweet_command_type) {
        return TWEET_COMMAND_TYPE.CREATE_TWEET.equals(tweet_command_type);
    }
}
