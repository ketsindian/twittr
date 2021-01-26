package com.twittr.app.model;

import com.google.gson.JsonElement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.jackson.JsonObjectDeserializer;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "admin_activity_d")
public class AdminActivityDAO {
    @Id
    @GeneratedValue
    private long activity_id;

    @Column(columnDefinition = "TEXT")
    private String request_data;

    @Column(columnDefinition = "TEXT")
    private String response_data;

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "admin_id")
    private Admin admin;

    @UpdateTimestamp
    private Date updated_ts;

    @CreationTimestamp
    private Date created_ts;

    private boolean request_approved;

    private Date request_approved_ts;
}
