package nu.kaffekod.workshopjpa.repository;

import nu.kaffekod.workshopjpa.entity.Author;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/* todo
[x] Find by first name.
[x] Find by last name
[x] Find by first name or last name containing a keyword.
[x] Find by a book's ID.
[x] Update name by ID.
[x] Delete by ID.
 */

public interface AuthorRepository extends CrudRepository<Author, Integer> {
    public List<Author> findByFirstName(String firstName);
    public List<Author> findByLastName(String lastName);
    public List<Author> findByFirstNameOrLastNameContaining(String firstName, String lastName);
    public List<Author> findAuthorByWrittenBooksId(int bookId);
    @Modifying
    @Query("update Author SET firstName = :firstName, lastName = :lastName where id = :id")
    public void setReturnedById(String firstName, String lastName, int id);
    public void removeById(int id);
}
