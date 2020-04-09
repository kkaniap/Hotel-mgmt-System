package edu.uekat.pl.hotel.repository;

import edu.uekat.pl.hotel.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<List<Reservation>> findByDateFrom(LocalDateTime date);

    @Query("SELECT r FROM Reservation r WHERE FUNCTION('MONTH', r.dateFrom) = FUNCTION('MONTH', :date)" +
            "AND FUNCTION('YEAR', r.dateFrom) = function('YEAR', :date)")
    Optional<List<Reservation>> findByDateFromYearMonth(@Param("date") LocalDateTime date);

   /* @Query("SELECT r FROM Reservation r WHERE FUNCTION('MONTH', r.dateFrom) = FUNCTION('MONTH' , :date) " +
            "AND FUNCTION('YEAR', r.dateFrom) = ")
    Optional<List<Reservation>> findByDateFromYearMonthDay(@Param("date") LocalDateTime date);*/
}
