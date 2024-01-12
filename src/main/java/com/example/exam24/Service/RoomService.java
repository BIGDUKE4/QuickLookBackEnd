package com.example.exam24.Service;
import com.example.exam24.Model.Room;
import com.example.exam24.Model.DTO.RoomDTO;
import com.example.exam24.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private final RoomRepository roomRepository;


    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    public RoomDTO convertToRoomDTO(Room room) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(room.getId());
        roomDTO.setNumberOfBeds(room.getNumberOfBeds());

        return roomDTO;
    }



}
