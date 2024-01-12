package com.example.exam24.Model.DTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelDetailsDTO {
    private Long id;
    private String name;
    private String street;
    private int numberOfRooms;
    private String city;
    private String zip;
    private String country;


}

