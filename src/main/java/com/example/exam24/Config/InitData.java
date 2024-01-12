package com.example.exam24.Config;

import com.example.exam24.Model.Hotel;
import com.example.exam24.Model.Room;
import com.example.exam24.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class InitData implements CommandLineRunner {

    private HotelRepository hotelRepository;

    @Autowired
    public InitData(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //generate 250 dummy hoteller
        for (int i = 0; i <= 250; i++) {
            Hotel hotel = generateDummyHotel(i);
            hotelRepository.save(hotel);
        }
    }

    public Hotel generateDummyHotel(int index) {
        Hotel hotel = new Hotel();
        hotel.setName("Hotel " + index);
        hotel.setStreet("Street " + index);
        hotel.setCity("City " + index);
        hotel.setCountry("Country " + index);
        hotel.setUpdated(LocalDateTime.now());
        hotel.setCreated(LocalDateTime.now());


        // Generer et tilfældigt antal værelser for hvert hotel
        int numberOfRooms = new Random().nextInt(31) + 10;
        // Sæt antallet af værelser for hotellet
        hotel.setNumberOfRooms(numberOfRooms);

        List<Room> rooms = new ArrayList<>();

        for (int j = 1; j <= numberOfRooms; j++) {
            Room room = new Room();
            room.setRoomNumber(j);
            // Generer et tilfældigt antal senge fra 1 til 4 for hvert værelse
            room.setNumberOfBeds(new Random().nextInt(4) + 1);

            // Sæt hotellet for værelset
            room.setHotel(hotel);

            rooms.add(room);
        }

        // Sæt listen over værelser i hotellet
        hotel.setRooms(rooms);

        return hotel;
    }


}
