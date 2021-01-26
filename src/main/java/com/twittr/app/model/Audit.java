package com.twittr.app.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.Entity;


@Getter
@Setter
@ToString
@EqualsAndHashCode
//@Entity
//@Inheritance(strategy=InheritanceType.JOINED)
public class Audit {
    private long eff_end_ts;

    private long eff_begin_ts;

    private long update_ts;

    private long created_ts;

}
