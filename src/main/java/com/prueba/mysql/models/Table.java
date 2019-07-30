package com.prueba.mysql.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity(name = "desk")
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Room room;

    private String name;

    private Boolean available;

//    public Room() {
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public RoomCategory getRoomCategory() {
//        return roomCategory;
//    }
//
//    public void setRoomCategory(RoomCategory roomCategory) {
//        this.roomCategory = roomCategory;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Room room = (Room) o;
//        return id == room.id &&
//                Objects.equals(roomCategory, room.roomCategory) &&
//                Objects.equals(name, room.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, roomCategory, name);
//    }
//
//    @Override
//    public String toString() {
//        return "Room{" +
//                "id=" + id +
//                ", roomCategory=" + roomCategory +
//                ", name='" + name + '\'' +
//                '}';
//    }
}
