package com.twittr.app.services;

import com.twittr.app.model.Tweet;
import com.twittr.app.model.User;
import com.twittr.app.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetService implements ITweetService{

    private final TweetRepository tweetRepository;

    @Autowired
    public TweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Override
    public List<Tweet> getTweetByUser(long userId) {
        return tweetRepository.getAllTweetsByUser(userId);
    }

    @Override
    public Tweet getTweetByUserIdTweetId(long userId, long tweetId) {
        return tweetRepository.getOne(tweetId);
    }

    @Override
    public Tweet createTweetForUser(Tweet tweet,long userId) {
        User user=new User();
        user.setUser_id(userId);
        tweet.setUser(user);
        return tweetRepository.save(tweet);
    }

    @Override
    public boolean deleteTweetForUser(long userId, long twitterId) {
        tweetRepository.deleteById(twitterId);
        return true;
    }
}
