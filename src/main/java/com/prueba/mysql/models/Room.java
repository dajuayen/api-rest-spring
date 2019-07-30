package com.prueba.mysql.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private RoomCategory roomCategory;

    @JsonBackReference
    @OneToMany(mappedBy = "room")
    private List<Table> tables;

    private String name;

}
