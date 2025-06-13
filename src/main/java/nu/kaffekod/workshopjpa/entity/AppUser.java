package nu.kaffekod.workshopjpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

/*
[x] id generated with the identity strategy
[x] username need to be unique
 */

@Entity
public @Data class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100, unique = true)
    private String username;
    @Column(nullable = false, length = 100)
    private @ToString.Exclude String password;
    private LocalDate regDate;
    @OneToOne
    @JoinColumn(name = "user_details_id")
    private Details userDetails;

    // Set default value
    public AppUser() {
        regDate = LocalDate.now();
    }

    public AppUser(int id, String username, String password, LocalDate regDate, Details userDetails) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.regDate = regDate;
        this.userDetails = userDetails;
    }

}
