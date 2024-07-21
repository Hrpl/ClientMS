package com.webapi.firstapi.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class StatusTask {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String Name;

    private String colorHex;


    @OneToMany(mappedBy = "statusTask")
    List<Task> tasks;
}
