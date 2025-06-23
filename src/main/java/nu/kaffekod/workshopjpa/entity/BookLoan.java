package nu.kaffekod.workshopjpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/*
[x] OPTIONAL calculate dueDate by using maxLoanDays from book
[ ] TODO OPTIONAL Add a new field boolean available in Book (Default value should be true).
     Make sure you set available to false when a BookLoan is added to AppUser.
     Also make sure you can NOT lend a book that has available set to false.
*/

@Entity
@Data
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private boolean returned;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "borrower_id")
    private AppUser borrower;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    private LocalDate loanDate;
    private LocalDate dueDate;


    public BookLoan(LocalDate loanDate, boolean returned, AppUser borrower, Book book) {
        this(returned, book);
        this.loanDate = loanDate;
        this.borrower = borrower;
        //setAppUser(borrower);
        this.dueDate = loanDate.plusDays(book.getMaxLoanDays());
    }

    public BookLoan(boolean returned, Book book) {
        this.returned = returned;
        this.book = book;
    }

    public BookLoan() {
        this.returned = true;
    }


    public void setAppUser(AppUser borrower) {
        /*
        IF borrower = null
          IF this.borrower != null
            DO remove this from borrower.bookLoans
          IF this.borrower != null
            DO nothing
        IF borrower != null
          DO add bookloans to borrower.bookLoans

        DO add borrower to this.borrower
         */
        List<BookLoan> currentBookLoans = borrower.getBookLoans();
        if (borrower == null || this.borrower != null) {
            currentBookLoans.remove(this);
            this.borrower.setBookLoans(currentBookLoans);
        }
        else {
            currentBookLoans.add(this);
            borrower.setBookLoans(currentBookLoans);
        }
        this.borrower = borrower;
    }
}
