package com.example.exam24.Model.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class RoomDTO {
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private int roomNumber;

    @Getter
    @Setter
    private int numberOfBeds;

    @Getter
    @Setter
    private LocalDateTime created;

    @Getter
    @Setter
    private LocalDateTime updated;

}
