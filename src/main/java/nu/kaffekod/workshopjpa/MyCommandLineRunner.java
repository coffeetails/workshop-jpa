package nu.kaffekod.workshopjpa;

import nu.kaffekod.workshopjpa.entity.AppUser;
import nu.kaffekod.workshopjpa.entity.Details;
import nu.kaffekod.workshopjpa.repository.AppUserRepository;
import nu.kaffekod.workshopjpa.repository.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    private DetailsRepository detailsRepository;
    private AppUserRepository appUserRepository;

    @Autowired
    public MyCommandLineRunner(DetailsRepository detailsRepository, AppUserRepository appUserRepository) {
        this.detailsRepository = detailsRepository;
        this.appUserRepository = appUserRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Application started ===");

        /* Create new data
        Details details1 = new  Details("sam@tidigt.com", "Sam Tidigt", LocalDate.of(1981, 2, 20));
        Details details2 = new  Details("stig@ner.com", "Stig Ner", LocalDate.of(1981, 2, 20));
        AppUser appUser1 = new AppUser("samtid", "pass", LocalDate.now(), details1);
        AppUser appUser2 = new AppUser("stiner", "pass", LocalDate.now(), details2);

        details1 = detailsRepository.save(details1);
        details2 = detailsRepository.save(details2);
        appUser1  = appUserRepository.save(appUser1);
        appUser2 = appUserRepository.save(appUser2);

        System.out.println("details1: " + details1);
        System.out.println("details2: " + details2);
        System.out.println("appuser1: " + appUser1);
        System.out.println("appuser2: " + appUser2);
        /* */

    }
}
