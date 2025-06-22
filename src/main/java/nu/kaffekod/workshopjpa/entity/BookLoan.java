package nu.kaffekod.workshopjpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate loanDate;
    private LocalDate dueDate;
    @Column(nullable = false)
    private boolean returned;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "borrower_id")
    private AppUser borrower;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    public BookLoan(LocalDate loanDate, boolean returned, AppUser borrower, Book book) {
        this(returned, book);
        this.loanDate = loanDate;
        this.borrower = borrower;
        this.dueDate = loanDate.plusDays(book.getMaxLoanDays());
    }

    public BookLoan(boolean returned, Book book) {
        this.returned = returned;
        this.book = book;
    }

    public BookLoan() {
        this.returned = true;
    }
}
