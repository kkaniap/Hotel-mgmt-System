package edu.uekat.pl.hotel.repository;

import edu.uekat.pl.hotel.model.Hotel;
import edu.uekat.pl.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByPriceBetween(BigDecimal low, BigDecimal high);

    @Query("SELECT r FROM Room r JOIN RoomType rt ON r.roomType.id = rt.id WHERE rt.typeName=:name")
    List<Room> findRoomsByRoomTypeName(@Param("name") String name);

}
