package edu.uekat.pl.hotel.repository;

import edu.uekat.pl.hotel.model.Hotel;
import edu.uekat.pl.hotel.model.Room;
import edu.uekat.pl.hotel.model.RoomType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class RoomTest {

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    RoomTypeRepository roomTypeRepository;
    @Autowired
    HotelRepository hotelRepository;
    static Room r1, r2, r3;
    static RoomType rt1, rt2;
    static Hotel h1;

    @BeforeAll
    static void setUp(){
        r1 = new Room(1,10,new BigDecimal("80.99"));
        r2 = new Room(1,25,new BigDecimal("50"));
        r3 = new Room(2, 51, new BigDecimal("50"));
        rt1 = new RoomType("Basic", 3.0D, "without any exclusives");
        rt2 = new RoomType("Exclusive", 5.5D, "with exclusives");
        h1 = new Hotel("HT-001", "Hotel Tychy", "Tychy", "Borowa 1", "43-443", 4, "Poland", "hoteltychy@gmail.com"
                ,"548563254");
    }

    @Test
    @DisplayName("save and find by price between")
    void saveAndFindByPriceBetween(){
        List<Room> roomList = List.of(r1, r2, r3);
        roomRepository.saveAll(roomList);
        List<Room> tmpRoomList = roomRepository.findByPriceBetween(new BigDecimal("40"), new BigDecimal("60"));
        assertEquals(2, tmpRoomList.size());
    }

    @Test
    @DisplayName("save and find by room type name")
    void saveAndFindByRoomTypeName(){
        roomTypeRepository.save(rt1);
        roomTypeRepository.save(rt2);

        r1.setRoomType(rt2);
        r2.setRoomType(rt1);
        r3.setRoomType(rt1);

        List<Room> roomList = List.of(r1, r2, r3);
        roomRepository.saveAll(roomList);
        List<Room> tmpRoomList = roomRepository.findRoomsByRoomTypeName("Basic");
        assertEquals(2, tmpRoomList.size());
    }

    @Test
    @DisplayName("save room with hotel")
    void saveRoomWithHotel(){
        hotelRepository.save(h1);

        List<Room> roomList = List.of(r1, r2, r3);
        for (Room r : roomList){
            r.setHotel(h1);
        }
        roomRepository.saveAll(roomList);

        Hotel tmpHotel = roomRepository.findById(2L).map(Room::getHotel).get();
        assertEquals("Hotel Tychy", tmpHotel.getName());
    }

}
