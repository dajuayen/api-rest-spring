package com.prueba.mysql.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class RoomCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String category;
    private String description;


    @JsonBackReference
    @OneToMany(mappedBy = "roomCategory",
            cascade = CascadeType.PERSIST)
    private List<Room> rooms;

}
