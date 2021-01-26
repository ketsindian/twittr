package com.twittr.app.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "user_d")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private long user_id;

    private String first_name;

    private String last_name;

    @NonNull
    private String email_id;

    private String phone_number;

    @UpdateTimestamp
    private Date updated_ts;

    @CreationTimestamp
    private Date created_ts;

    private boolean active;

    private USER_TYPE user_type;
}
