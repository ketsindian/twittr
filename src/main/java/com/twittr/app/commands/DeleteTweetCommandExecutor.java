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
public class DeleteTweetCommandExecutor extends TweetCommandExecutor{

    private final ITweetService tweetService;
    private final AdminActivityRepository adminActivityRepository;

    @Autowired
    public DeleteTweetCommandExecutor(ITweetService tweetService, AdminActivityRepository adminActivityRepository) {
        this.tweetService = tweetService;
        this.adminActivityRepository = adminActivityRepository;
    }


    @Override
    public boolean isValid(AdminActivityRequest adminActivityRequest) {
        return adminActivityRequest!=null && adminActivityRequest.getTweet()!=null && adminActivityRequest.getTweet().getTweet_id()!=0;
    }

    @Override
    public void executeCommand(long activityId,AdminActivityRequest activityData) {
        boolean res=tweetService.deleteTweetForUser(activityData.getUser().getUser_id(),activityData.getTweet().getTweet_id());
        adminActivityRepository.updateAdminActivityResponse(activityId, Boolean.toString(res));
    }

    @Override
    public boolean isApplicable(TWEET_COMMAND_TYPE tweet_command_type) {
        return TWEET_COMMAND_TYPE.DELETE_TWEET.equals(tweet_command_type);
    }

}
