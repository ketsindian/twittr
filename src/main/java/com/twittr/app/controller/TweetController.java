package com.twittr.app.controller;

import com.twittr.app.model.Tweet;
import com.twittr.app.model.User;
import com.twittr.app.services.ITweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TweetController {

    private final ITweetService tweetService;

    @Autowired
    public TweetController(ITweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping("/user/{userId}/tweets")
    public List<Tweet> getTweetsForUser(@Validated @PathVariable long userId) {
        return tweetService.getTweetByUser(userId);
    }

    @PostMapping("/user/{userId}/tweet")
    public Tweet createTweetForUser(@Validated @RequestBody Tweet tweet,@Validated @PathVariable long userId) {
        return tweetService.createTweetForUser(tweet,userId);
    }

    @DeleteMapping("/user/{userId}/tweet/{tweetId}")
    public boolean deleteTweet(@Validated @PathVariable long tweetId,@Validated @PathVariable long userId) {
        return tweetService.deleteTweetForUser(userId,tweetId);
    }
}
