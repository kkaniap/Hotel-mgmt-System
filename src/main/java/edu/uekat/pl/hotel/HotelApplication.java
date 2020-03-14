package edu.uekat.pl.hotel;

import edu.uekat.pl.hotel.model.Guest;
import edu.uekat.pl.hotel.repository.GuestRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class HotelApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelApplication.class, args);
    }


}
