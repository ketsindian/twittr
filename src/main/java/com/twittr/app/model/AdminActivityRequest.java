package com.twittr.app.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AdminActivityRequest {
    private TWEET_COMMAND_TYPE activity_type;

    private Tweet tweet;

    private User user;
}
