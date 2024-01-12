package com.example.exam24;

import com.example.exam24.Config.InitData;
import com.example.exam24.Model.Hotel;
import com.example.exam24.Model.Room;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InitDataTest {

    @Autowired
    private InitData initData;

    @Test
    @Transactional
    void generateHotelTest() {
        int index = 1;

        Hotel hotel = initData.generateDummyHotel(index);

        assertNotNull(hotel);
        assertEquals("Hotel " + index, hotel.getName());
        assertEquals("Street " + index, hotel.getStreet());
        assertEquals("City " + index, hotel.getCity());
        assertEquals("Country " + index, hotel.getCountry());
        assertNotNull(hotel.getCreated());
        assertNotNull(hotel.getUpdated());
        assertTrue(hotel.getNumberOfRooms() >= 10 && hotel.getNumberOfRooms() <= 40);

        List<Room> rooms = hotel.getRooms();
        assertNotNull(rooms);
        assertEquals(hotel.getNumberOfRooms(), rooms.size());

        for (Room room : rooms) {
            assertNotNull(room);
            assertEquals(index, room.getHotel().getId());
            assertNotNull(room.getRoomNumber());
            assertTrue(room.getNumberOfBeds() >= 1 && room.getNumberOfBeds() <= 4);
        }
    }
}
