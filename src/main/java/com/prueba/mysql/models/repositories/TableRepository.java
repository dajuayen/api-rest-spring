package com.prueba.mysql.models.repositories;

import com.prueba.mysql.models.Room;
import com.prueba.mysql.models.Table;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TableRepository extends CrudRepository<Table, Long>  {

    Optional<Table> findTableByIdAndRoom_Id(Long id, Long room_id);
    Iterable<Table> findTablesByRoom(Room room);
    Iterable<Table> findTablesByRoomAndAndAvailable(Room room, Boolean avail);
    Iterable<Table> getTablesByRoom_IdAndAvailable(Long id, Boolean avail);

}
