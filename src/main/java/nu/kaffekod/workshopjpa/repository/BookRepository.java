package nu.kaffekod.workshopjpa.repository;

import nu.kaffekod.workshopjpa.entity.Book;
import org.springframework.data.repository.CrudRepository;

/*
[x] Basic CRUD Operations.
[x] Find by isbn ignore case.
[x] Find by title contains.
[x] Find by max loan days less than.
*/

public interface BookRepository extends CrudRepository<Book, Integer> {
    public Book findByIsbnIgnoreCase(String isbn);
    public Book findByTitleContaining(String title);
    public Book findByMaxLoanDaysLessThan(int maxLoanDays);
}
