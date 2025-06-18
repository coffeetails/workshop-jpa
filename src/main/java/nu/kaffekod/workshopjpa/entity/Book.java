package nu.kaffekod.workshopjpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
public @Data class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100, unique = true)
    private String isbn;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false)
    private int maxLoanDays;

    public Book(String isbn, String title, int maxLoanDays) {
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
    }

    public Book() {
        maxLoanDays = 30;
    }
}
