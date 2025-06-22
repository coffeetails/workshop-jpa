package nu.kaffekod.workshopjpa.repository;

import nu.kaffekod.workshopjpa.entity.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

/*
[x] Basic CRUD Operations.
[x] Find by Username.
[x] Find by registration date between two specific dates.
[x] Find by details id.
[x] Find by email ignore case.
[ ] (Optional) Add more as needed.
 */

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    List<AppUser> findByUsername(String username);
    List<AppUser> findByRegDateBetween(LocalDate start, LocalDate end);
    AppUser findByUserDetailsId(int id);
    AppUser findByUserDetailsEmailIgnoreCase(String email);

}
