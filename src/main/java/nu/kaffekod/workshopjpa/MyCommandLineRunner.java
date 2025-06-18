package nu.kaffekod.workshopjpa;

import nu.kaffekod.workshopjpa.entity.AppUser;
import nu.kaffekod.workshopjpa.entity.Book;
import nu.kaffekod.workshopjpa.entity.BookLoan;
import nu.kaffekod.workshopjpa.entity.Details;
import nu.kaffekod.workshopjpa.repository.AppUserRepository;
import nu.kaffekod.workshopjpa.repository.BookLoanRepository;
import nu.kaffekod.workshopjpa.repository.BookRepository;
import nu.kaffekod.workshopjpa.repository.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    private final DetailsRepository detailsRepository;
    private final AppUserRepository appUserRepository;
    private final BookRepository bookRepository;
    private final BookLoanRepository bookLoanRepository;

    @Autowired
    public MyCommandLineRunner(DetailsRepository detailsRepository, AppUserRepository appUserRepository, BookRepository bookRepository, BookLoanRepository bookLoanRepository) {
        this.detailsRepository = detailsRepository;
        this.appUserRepository = appUserRepository;
        this.bookRepository = bookRepository;
        this.bookLoanRepository = bookLoanRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Application started ===");

        Details details1 = new  Details("sam@tidigt.com", "Sam Tidigt", LocalDate.of(1981, 2, 20));
        Details details2 = new  Details("stig@ner.com", "Stig Ner", LocalDate.of(1981, 2, 20));
        AppUser appUser1 = new AppUser("samtid", "pass", LocalDate.now(), details1);
        AppUser appUser2 = new AppUser("stiner", "pass", LocalDate.now(), details2);
        Book book1 = new Book("1223416660", "The Hobbit", 30);
        Book book2 = new Book("2342352134", "1984", 30);
        BookLoan bookLoan1 = new BookLoan(LocalDate.now(), false, appUser1, book1);
        BookLoan bookLoan2 = new BookLoan(LocalDate.now(), false, appUser2, book2);

        /*
        details1 = detailsRepository.save(details1);
        details2 = detailsRepository.save(details2);
        /**/
        /*
        appUser1  = appUserRepository.save(appUser1);
        appUser2 = appUserRepository.save(appUser2);
        /**/
        /*
        book1 = bookRepository.save(book1);
        book2 = bookRepository.save(book2);
        /**/
        /*
        bookLoan1 = bookLoanRepository.save(bookLoan1);
        bookLoan2 = bookLoanRepository.save(bookLoan2);
        /**/

        System.out.println("details1: " + details1.toString());
        System.out.println("details2: " + details2.toString());
        System.out.println("appuser1: " + appUser1.toString());
        System.out.println("appuser2: " + appUser2.toString());
        System.out.println("book1: " + book1.toString());
        System.out.println("book2: " + book2.toString());
        System.out.println("bookLoan1: " + bookLoan1.toString());
        System.out.println("bookLoan2: " + bookLoan2.toString());

    }
}
