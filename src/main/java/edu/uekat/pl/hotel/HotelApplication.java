package edu.uekat.pl.hotel;

import edu.uekat.pl.hotel.controller.HotelGUI;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelApplication.class, args);
        Application.launch(HotelGUI.class);
    }


}
