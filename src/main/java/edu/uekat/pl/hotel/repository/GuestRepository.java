package edu.uekat.pl.hotel.repository;

import edu.uekat.pl.hotel.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

    Optional<Guest> findByIdNumber(String idNumber);
    Optional<Guest> findByFirstNameAndLastName(String firstName, String lastName);
}
