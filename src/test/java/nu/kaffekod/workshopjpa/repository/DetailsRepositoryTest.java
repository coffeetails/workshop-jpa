package nu.kaffekod.workshopjpa.repository;

import nu.kaffekod.workshopjpa.entity.Details;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.Assert;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DetailsRepositoryTest {

    @Autowired
    private DetailsRepository detailsRepository;

    @Test
    @DisplayName("Find by email")
    void testFindByEmail() {
        List<Details> foundDetails = detailsRepository.findByEmail("william.harris@example.com");
        Assert.notEmpty(foundDetails, "found details");
    }

    @Test
    @DisplayName("Find by name contains")
    void testFindByNameContainingIgnoreCase() {
        List<Details> foundDetails = detailsRepository.findByNameContainingIgnoreCase("ar");
        Assert.notEmpty(foundDetails, "found details");
        assertThat(foundDetails).hasSize(3);
    }

    @Test
    @DisplayName("Find by name ignore-case")
    void testFindByNameIgnoreCase() {
        List<Details> foundDetails = detailsRepository.findByNameIgnoreCase("JaMeS dAvIs");
        Assert.notEmpty(foundDetails, "found details");
        assertThat(foundDetails).hasSize(1);
    }
}
