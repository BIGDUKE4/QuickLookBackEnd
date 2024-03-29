package com.example.exam24.Model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

    @Entity
    @Getter
    @Setter
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String username;

        @Column(nullable = false)
        private String password;

    }

