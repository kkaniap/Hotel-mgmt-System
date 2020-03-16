package edu.uekat.pl.hotel.repository;

import edu.uekat.pl.hotel.model.RoomType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RoomTypeTest {

    @Autowired
    RoomTypeRepository roomTypeRepository;
    static RoomType rt1;

    @BeforeAll
    static void setUp(){
        rt1 = new RoomType("Basic", 3.0D, "without any exclusives");
    }

    @Test
    @DisplayName("save and find by type name")
    void saveAndFindByTypeNameNotNull(){
        roomTypeRepository.save(rt1);
        assertTrue(roomTypeRepository.findByTypeName("Basic").isPresent());
    }

    @Test
    @DisplayName("save and find by type name")
    void saveAndFindByTypeNameIsNull(){
        roomTypeRepository.save(rt1);
        assertTrue(roomTypeRepository.findByTypeName("cheap").isEmpty());
    }
}
