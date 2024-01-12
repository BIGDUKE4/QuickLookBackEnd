package com.example.exam24.Service;

import com.example.exam24.Model.DTO.HotelListDTO;
import com.example.exam24.Model.Hotel;
import com.example.exam24.Model.Room;
import com.example.exam24.Model.DTO.HotelDTO;
import com.example.exam24.Model.DTO.RoomDTO;
import com.example.exam24.Service.RoomService;


import com.example.exam24.Repository.HotelRepository;
import com.example.exam24.Repository.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }

    private HotelDTO convertToHotelDTO(Hotel hotel) {
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setId(hotel.getId());
        hotelDTO.setName(hotel.getName());
        hotelDTO.setStreet(hotel.getStreet());
        hotelDTO.setCity(hotel.getCity());
        hotelDTO.setZip(hotel.getZip());
        hotelDTO.setCountry(hotel.getCountry());
        hotelDTO.setNumberOfRooms(hotel.getNumberOfRooms());
        hotelDTO.setCreated(LocalDateTime.now());
        hotelDTO.setUpdated(LocalDateTime.now());


        return hotelDTO;
    }
    public List<HotelListDTO> getAllHotelsList() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream()
                .map(this::convertToHotelListDTO)
                .collect(Collectors.toList());
    }
    public HotelListDTO convertToHotelListDTO(Hotel hotel) {
        HotelListDTO hotelListDTO = new HotelListDTO();
        hotelListDTO.setId(hotel.getId());
        hotelListDTO.setName(hotel.getName());
        return hotelListDTO;
    }





    public Hotel createHotel(HotelDTO hotelDTO) {
        Hotel newHotel = new Hotel();
        newHotel.setName(hotelDTO.getName());
        newHotel.setCity(hotelDTO.getCity());
        newHotel.setStreet(hotelDTO.getStreet());
        newHotel.setZip(hotelDTO.getZip());
        newHotel.setCountry(hotelDTO.getCountry());
        newHotel.setNumberOfRooms(hotelDTO.getNumberOfRooms());
        newHotel.setCreated(hotelDTO.getCreated());
        newHotel.setCreated(hotelDTO.getUpdated());


        return hotelRepository.save(newHotel);

    }

    public String deleteHotel(long hotelId) {
        hotelRepository.deleteById(hotelId);
        return "Hotel slettet";
    }

    public List<HotelDTO> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream()
                .map(this::convertToHotelDTO)
                .collect(Collectors.toList());
    }

    public HotelDTO getHotelDetails(long hotelId) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
        if (optionalHotel.isPresent()) {
            Hotel hotel = optionalHotel.get();
            return convertToHotelDTO(hotel);
        } else {

            return null;
        }
    }

    public RoomDTO createRoom(long hotelId, RoomDTO roomDTO) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);

        if (optionalHotel.isPresent()) {
            Hotel hotel = optionalHotel.get();
            Room newRoom = new Room();
            newRoom.setNumberOfBeds(roomDTO.getNumberOfBeds());
            newRoom.setRoomNumber(roomDTO.getRoomNumber());
            newRoom.setCreated(roomDTO.getCreated());
            newRoom.setUpdated(roomDTO.getUpdated());

            newRoom.setHotel(hotel);
            Room savedRoom = roomRepository.save(newRoom);


            return convertToRoomDTO(savedRoom);
        } else {

            return null;
        }
    }


    // lappeløsning da den ikke kunne finde convertToRoomDTO på andre måder.
    private RoomDTO convertToRoomDTO(Room savedRoom) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(savedRoom.getId());
        roomDTO.setRoomNumber(savedRoom.getRoomNumber());
        roomDTO.setNumberOfBeds(savedRoom.getNumberOfBeds());
        roomDTO.setCreated(savedRoom.getCreated());
        roomDTO.setUpdated(savedRoom.getUpdated());

        return roomDTO;
    }



    public Hotel updateHotel(Long hotelId, HotelDTO updatedHotelDTO) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);

        if (optionalHotel.isPresent()) {
            Hotel existingHotel = optionalHotel.get();


            existingHotel.setName(updatedHotelDTO.getName());
            existingHotel.setCity(updatedHotelDTO.getCity());
            existingHotel.setStreet(updatedHotelDTO.getStreet());
            existingHotel.setZip(updatedHotelDTO.getZip());
            existingHotel.setCountry(updatedHotelDTO.getCountry());
            existingHotel.setNumberOfRooms(updatedHotelDTO.getNumberOfRooms());

            // her gemmer jeg det opdaterede hotel
            Hotel updatedHotel = hotelRepository.save(existingHotel);
            return updatedHotel;



        } else {

            return null;
        }
    }
}
