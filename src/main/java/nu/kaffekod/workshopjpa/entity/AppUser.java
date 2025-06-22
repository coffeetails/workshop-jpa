package nu.kaffekod.workshopjpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

/*
[x] id generated with the identity strategy
[x] username need to be unique
 */

@Data
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100, unique = true)
    private String username;
    @ToString.Exclude
    @Column(nullable = false, length = 100)
    private String password;
    private LocalDate regDate;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private Details userDetails; // details_id

    // Set default value
    public AppUser() {
        regDate = LocalDate.now();
    }

    public AppUser(String username, String password, LocalDate regDate, Details userDetails) {
        this.username = username;
        this.password = password;
        this.regDate = regDate;
        this.userDetails = userDetails;
    }

}
