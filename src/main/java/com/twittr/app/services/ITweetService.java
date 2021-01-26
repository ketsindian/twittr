package com.twittr.app.services;

import com.twittr.app.model.Tweet;

import java.util.List;

public interface ITweetService {

    public List<Tweet> getTweetByUser(long userId);

    public Tweet getTweetByUserIdTweetId(long userId,long tweetId);

    public Tweet createTweetForUser(Tweet tweet,long userId);

    public boolean deleteTweetForUser(long userId,long twitterId);
}
