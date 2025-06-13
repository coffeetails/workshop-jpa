package nu.kaffekod.workshopjpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

/*
[x] id generated with identity strategy
[x] email need to be unique
 */

@Entity
public @Data class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    @Column(nullable = false, length = 100)
    private String name;
    private LocalDate birthDate;

    public Details(int id, String email, String name, LocalDate birthDate) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Details() {

    }
}
