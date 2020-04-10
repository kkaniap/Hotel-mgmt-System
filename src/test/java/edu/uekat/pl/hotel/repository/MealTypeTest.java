package edu.uekat.pl.hotel.repository;

import edu.uekat.pl.hotel.model.MealType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MealTypeTest {

    @Autowired
    MealTypeRepository mealTypeRepo;

    @Test
    @DisplayName("Save and find meal type by name")
    void findMealTypeByNameNotNull(){
        //given
        MealType mt1 = new MealType("HB", "Breakfast and Lunch");
        //when
        mealTypeRepo.save(mt1);
        Optional<MealType> result = mealTypeRepo.findByMealType("HB");
        //then
        assertEquals("HB".toLowerCase(), result.get().getMealType().toLowerCase());
    }

    @Test
    @DisplayName("Find meal type by not exisitng name")
    void findMealTypeByName(){
        //given
        String name = "AA";
        //when
        Optional<MealType> result = mealTypeRepo.findByMealType("name");
        //then
        assertFalse(result.isPresent());
    }

}
