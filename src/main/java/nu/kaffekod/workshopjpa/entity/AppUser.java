package nu.kaffekod.workshopjpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
[x] id generated with the identity strategy
[x] username need to be unique

[x] Add list of entity 'BookLoan'
[x] Set up OneToMany relationship to BookLoan
[x] Add method to add BookLoan in a bidirectional way
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

    @ToString.Exclude
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "book_loan_id")
    private List<BookLoan> bookLoans = new ArrayList<>();


    // Set default value
    public AppUser() {
        regDate = LocalDate.now();
    }

    public AppUser(String username, String password, LocalDate regDate, Details userDetails, BookLoan bookLoan) {
        this(username, password, regDate, userDetails);
        setBookLoan(bookLoan);
    }

    public AppUser(String username, String password, LocalDate regDate, Details userDetails) {
        this.username = username;
        this.password = password;
        this.regDate = regDate;
        this.userDetails = userDetails;
    }



    public void setBookLoan(BookLoan bookLoan) {
        if(bookLoan.getBorrower() == null || !bookLoan.getBorrower().equals(this)) {
            bookLoan.setBorrower(this);
        }
        this.bookLoans.add(bookLoan);
    }
}
