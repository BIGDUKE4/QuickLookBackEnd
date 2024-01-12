package com.example.exam24.Controller;
import com.example.exam24.Model.DTO.HotelDTO;
import com.example.exam24.Model.DTO.RoomDTO;
import com.example.exam24.Model.Hotel;
import com.example.exam24.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.exam24.Config.InitData;

import java.util.List;



@RestController
@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
public class HotelController {
    private HotelService hotelService;


    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }




    @PostMapping("/create-hotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody HotelDTO hotelDTO) {
        Hotel createdHotel = hotelService.createHotel(hotelDTO);
        return new ResponseEntity<>(createdHotel, HttpStatus.CREATED);
    }


    @GetMapping("/all-hotels")
    public ResponseEntity<List<HotelDTO>> getAllHotels() {
        List<HotelDTO> hotels = hotelService.getAllHotels();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }


    @GetMapping("/hotel-details/{hotelId}")
    public ResponseEntity<HotelDTO> getHotelDetails(@PathVariable Long hotelId) {
        HotelDTO hotelDetails = hotelService.getHotelDetails(hotelId);
        return new ResponseEntity<>(hotelDetails, HttpStatus.OK);
    }


    @PutMapping("/update-hotel/{hotelId}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable Long hotelId, @RequestBody HotelDTO hotelDTO) {
        Hotel updatedHotel = hotelService.updateHotel(hotelId, hotelDTO);
        return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
    }


    @DeleteMapping("/delete-hotel/{hotelId}")
    public ResponseEntity<String> deleteHotel(@PathVariable Long hotelId) {
        String result = hotelService.deleteHotel(hotelId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PostMapping("/create-room/{hotelId}")
    public ResponseEntity<RoomDTO> createRoom(@PathVariable Long hotelId, @RequestBody RoomDTO roomDTO) {
        RoomDTO createdRoom = hotelService.createRoom(hotelId, roomDTO);
        return new ResponseEntity<>(createdRoom, HttpStatus.CREATED);
    }
}


