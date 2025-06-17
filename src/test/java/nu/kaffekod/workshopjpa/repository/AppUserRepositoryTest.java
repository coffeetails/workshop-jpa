package nu.kaffekod.workshopjpa.repository;

import nu.kaffekod.workshopjpa.entity.AppUser;
import nu.kaffekod.workshopjpa.entity.Details;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class AppUserRepositoryTest {

    @Autowired
    private AppUserRepository appUserRepository;


    @Test
    @DisplayName("Save details")
    void testSaveAppUser() {

        AppUser appUser = new AppUser(
                "edha", "pass", LocalDate.now(),
                new Details("edde@hansen.com", "Eddie Hansen", LocalDate.of(1971, 4, 22))
        );

        AppUser savedAppUser =  appUserRepository.save(appUser);

        Assert.notNull(savedAppUser.getId(), "generate id");
        Assert.isTrue(savedAppUser.getId() == 1, "correct id");
    }

    @Test
    @DisplayName("Find user by username")
    void testFindByUsername() {
        List<AppUser> foundByUsername = appUserRepository.findByUsername("olimar");

        assertThat(foundByUsername).hasSize(1);
    }

    @Test
    @DisplayName("Find users between two reg dates")
    void testFindByRegDateBetween() {
        List<AppUser> foundByRegDateBetween = appUserRepository.findByRegDateBetween(
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2022, 12, 31)
        );
        assertThat(foundByRegDateBetween).hasSize(2);
    }

    @Test
    @DisplayName("Find user by id in details")
    void testFindByUserDetailsId() {
        AppUser appUser = appUserRepository.findByUserDetailsId(30);
        System.out.println("→ → → " + appUser.toString());
        assertThat(appUser.getUsername()).isEqualTo("avagar");
    }

    @Test
    @DisplayName("Find user by email in details")
    void testFindByUserDetailsEmailIgnoreCase() {
        AppUser appUser = appUserRepository.findByUserDetailsEmailIgnoreCase("iSaBeLlA.MiLlEr@example.com");

        assertThat(appUser.getUsername()).isEqualTo("isamil");
    }
}

