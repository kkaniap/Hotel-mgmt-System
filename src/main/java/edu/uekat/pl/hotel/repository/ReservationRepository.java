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

    /***
     * Method ignores hours,minutes and days
     * @return List with all reservations equals to year and month
     */
    @Query("SELECT r FROM Reservation r WHERE FUNCTION('MONTH', r.dateFrom) = FUNCTION('MONTH', :date)" +
            "AND FUNCTION('YEAR', r.dateFrom) = FUNCTION('YEAR', :date)")
    List<Reservation> findByDateFromYearMonth(@Param("date") LocalDateTime date);

    /***
     * Method ignores hours and minutes
     * @return List with all reservations equals to year,month and day
     */
    @Query("SELECT r FROM Reservation r WHERE FUNCTION('MONTH', r.dateFrom) = FUNCTION('MONTH' , :date) " +
            "AND FUNCTION('YEAR', r.dateFrom) = FUNCTION('YEAR', :date) AND FUNCTION('DAY', r.dateFrom) = FUNCTION('DAY', :date)")
    List<Reservation> findByDateFromYearMonthDay(@Param("date") LocalDateTime date);
}
