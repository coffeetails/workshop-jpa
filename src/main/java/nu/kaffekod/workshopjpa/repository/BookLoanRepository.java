package nu.kaffekod.workshopjpa.repository;

import nu.kaffekod.workshopjpa.entity.BookLoan;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/* todo
[x] Basic CRUD Operations.
[x] Find by borrower's ID.
[x] Find by book ID.
[x] Find all book loans that have not been returned yet.
[x] Find all overdue book loans.
[x] Find loans between dates.
[x] Mark a book loan as returned by its loan ID.
*/

public interface BookLoanRepository extends CrudRepository<BookLoan, Integer> {
    public BookLoan findByBorrowerId(int id);
    public BookLoan findByBookId(int id);
    public Iterable<BookLoan> findByReturnedFalse();
    public Iterable<BookLoan> findByDueDateBefore(java.time.LocalDate date);
    public Iterable<BookLoan> findByLoanDateBetween(java.time.LocalDate start, java.time.LocalDate end);
    @Modifying
    @Query("update BookLoan SET BookLoan = true where BookLoan.id = ?1")
    void setReturnedById(int id);
}
