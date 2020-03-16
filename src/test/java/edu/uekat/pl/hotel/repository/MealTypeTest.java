package edu.uekat.pl.hotel.repository;

import edu.uekat.pl.hotel.model.MealType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MealTypeTest {

    @Autowired
    MealTypeRepository mealTypeRepository;
    static MealType m1;

    @BeforeAll
    static void setUp(){
        m1 = new MealType("all inclusive", "drinks and food is for free");
    }

    @Test
    @DisplayName("find meal type by name is not null")
    void findMealTypeByNameNotNull(){
        mealTypeRepository.save(m1);
        assertTrue(mealTypeRepository.findByMealType("all inclusive").isPresent());
    }

    @Test
    @DisplayName("find meal type by name")
    void findMealTypeByName(){
        mealTypeRepository.save(m1);
        assertTrue(mealTypeRepository.findByMealType("1").isEmpty());
    }

}
