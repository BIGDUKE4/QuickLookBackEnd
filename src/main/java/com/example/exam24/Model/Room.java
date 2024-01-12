package com.example.exam24.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "rooms")
public class Room {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name ="id", nullable = false)
        private long id;

        @Column(nullable = false)
        private int roomNumber;

        @Column(nullable = false)
        private int numberOfBeds;

        @Column()
        private LocalDateTime created;

        @Column()
        private LocalDateTime updated;



        @ManyToOne
        @JoinColumn(name = "hotel_id", nullable = false)
        private Hotel hotel;

        @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
        private List<Reservation> reservations;


}



