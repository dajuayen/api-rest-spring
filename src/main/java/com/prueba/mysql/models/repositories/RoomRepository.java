package com.prueba.mysql.models.repositories;

import com.prueba.mysql.models.Room;
import com.prueba.mysql.models.RoomCategory;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Long>  {
    Iterable<Room> findByRoomCategory(RoomCategory roomCategory);
}
