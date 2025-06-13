package nu.kaffekod.workshopjpa.repository;

import nu.kaffekod.workshopjpa.entity.Details;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/*
[x] Basic CRUD Operations.
[x] Find by email.
[x] Find by name contains.
[x] Find name ignore-case.
[ ] (Optional) Add more as needed.
 */

public interface DetailsRepository extends CrudRepository<Details, Integer> {

    List<Details> findByEmail(String email);
    List<Details> findByNameContainingIgnoreCase(String name);
    List<Details> findByNameIgnoreCase(String name);

}
