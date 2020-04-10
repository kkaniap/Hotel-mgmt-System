package edu.uekat.pl.hotel.repository;

import edu.uekat.pl.hotel.model.RoomType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RoomTypeTest {

    @Autowired
    RoomTypeRepository roomTypeRepo;

    @Test
    @DisplayName("save and find by type name")
    void saveAndFindByTypeName(){
        //given
        RoomType roomType = new RoomType("TestRoom", 1D, "testing");
        //when
        roomTypeRepo.save(roomType);
        Optional<RoomType> result = roomTypeRepo.findByTypeName("TestRoom");
        //then
        assertEquals("TestRoom".toLowerCase(), result.get().getTypeName().toLowerCase());
    }

    @Test
    @DisplayName("save and find by not existing type name")
    void saveAndFindByTypeNameIsNull(){
        //given
        String name = "Existing";
        //when
        Optional<RoomType> result = roomTypeRepo.findByTypeName(name);
        //then
        assertFalse(result.isPresent());
    }
}
