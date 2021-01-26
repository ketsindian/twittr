package com.twittr.app.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "tweets_d")
public class Tweet implements Serializable {
    @Id
    @GeneratedValue
    private long tweet_id;

    private String tweet_data;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @UpdateTimestamp
    private Date updated_ts;

    @CreationTimestamp
    private Date created_ts;

    private boolean active;
}
