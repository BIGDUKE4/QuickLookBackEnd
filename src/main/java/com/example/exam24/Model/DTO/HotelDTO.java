package com.example.exam24.Model.DTO;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter

public class HotelDTO {
    private Long id;
    private String name;
    private String street;
    private String city;
    private int zip;
    private String country;
    private int numberOfRooms;
    private int numberOfBeds;
    private LocalDateTime created;
    private LocalDateTime updated;



}
