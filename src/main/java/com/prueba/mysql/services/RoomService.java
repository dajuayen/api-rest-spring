package com.prueba.mysql.services;


import com.prueba.mysql.models.*;
import com.prueba.mysql.models.repositories.RoomCategoryRepository;
import com.prueba.mysql.models.repositories.RoomRepository;
import com.prueba.mysql.models.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RoomCategoryRepository categoryRepository;

    @Autowired
    TableRepository tableRepository;

    public List<Room> findAllRooms() {
        return (List<Room>) roomRepository.findAll();
    }

    public List<Room> findRoomsByCategoryId(Long category_id) {
        Optional<RoomCategory> category = categoryRepository.findById(category_id);
        return (List<Room>) roomRepository.findByRoomCategory(category.get());
    }

    public List<Table> findTablesByRoomId(Long id){
        Room room = findRoomById(id);
//        Optional<Table> tables =
        return (List<Table>) room.getTables();
    }

    public List<Table> findTablesByRoomIdAndAvail(Long id, boolean avail){
        return (List<Table>) tableRepository.getTablesByRoom_IdAndAvailable(id, avail);
    }

    public Room findRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No room found with id: [" + id + "]"));
    }

    public long insertRoom(Room room) {
        return roomRepository.save(room).getId();
    }

    public long updateRoom(Room room) {
        return roomRepository.save(room).getId();
    }

    public void deleteRoomById(Long id) {
        roomRepository.deleteById(id);
    }


/*    CATEGORIES    */

    public List<RoomCategory> findAllCategories() {
        return (List<RoomCategory>) categoryRepository.findAll();
    }

    public List<Room> findCategoryRooms(Long id) {

        RoomCategory category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No category found with id: [" + id + "]"));
        return category.getRooms();
    }

    public RoomCategory findCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No category found with id: [" + id + "]"));
    }

    public long insertCategory(RoomCategory category) {
        return categoryRepository.save(category).getId();
    }

    public long updateCategory(RoomCategory category) {
        return categoryRepository.save(category).getId();
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    /*    TABLES    */

    public Table insertOrUpdateTable(Table table) {
        return tableRepository.save(table);
    }

    public Table changeAvailableTable(Long id, Long room_id){
        Optional<Table> table = tableRepository.findTableByIdAndRoom_Id(id,room_id);
        table.get().setAvailable(!table.get().getAvailable());
        return tableRepository.save(table.get());
    }

}
