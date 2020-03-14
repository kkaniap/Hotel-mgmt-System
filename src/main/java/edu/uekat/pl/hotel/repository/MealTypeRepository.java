package edu.uekat.pl.hotel.repository;

import edu.uekat.pl.hotel.model.MealType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealTypeRepository extends JpaRepository<MealType, Long> {
}
