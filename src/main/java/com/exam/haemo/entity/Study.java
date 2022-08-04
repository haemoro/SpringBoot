package com.exam.haemo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Study {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private Account owner;
}
