package edu.uekat.pl.hotel.repository;

import edu.uekat.pl.hotel.model.Hotel;
import edu.uekat.pl.hotel.model.Room;
import edu.uekat.pl.hotel.model.RoomType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class RoomTest {

    @Autowired
    RoomRepository roomRepo;
    @Autowired
    RoomTypeRepository roomTypeRepo;
    @Autowired
    HotelRepository hotelRepo;

    @Test
    @DisplayName("save and find all rooms by price between")
    void saveAndFindByPriceBetween(){
        //given
        Room r1 = new Room(1,10,new BigDecimal("80.99"));
        //when
        roomRepo.save(r1);
        List<Room> rooms = roomRepo.findByPriceBetween(BigDecimal.valueOf(50.00), BigDecimal.valueOf(100.00));
        //then
        assertEquals(7, rooms.size());
    }

    @Test
    @DisplayName("save and find all rooms by room type name")
    @Transactional
    void saveAndFindByRoomTypeName(){
        //given
        Room r1 = new Room(12,102,new BigDecimal("80.99"));
        //when
        Optional<RoomType> roomType = roomTypeRepo.findByTypeName("Comfort");
        r1.addRoomTypeToRoom(roomType.get());
        int rooms = roomRepo.findRoomsByRoomTypeName("Comfort").size();
        //then
        assertEquals(7, rooms);
    }
}
