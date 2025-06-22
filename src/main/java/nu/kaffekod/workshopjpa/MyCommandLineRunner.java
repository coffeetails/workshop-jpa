package nu.kaffekod.workshopjpa;

import nu.kaffekod.workshopjpa.entity.*;
import nu.kaffekod.workshopjpa.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    private final DetailsRepository detailsRepository;
    private final AppUserRepository appUserRepository;
    private final BookRepository bookRepository;
    private final BookLoanRepository bookLoanRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public MyCommandLineRunner(DetailsRepository detailsRepository, AppUserRepository appUserRepository, BookRepository bookRepository, BookLoanRepository bookLoanRepository, AuthorRepository authorRepository) {
        this.detailsRepository = detailsRepository;
        this.appUserRepository = appUserRepository;
        this.bookRepository = bookRepository;
        this.bookLoanRepository = bookLoanRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Application started ===");


        Details details1 = detailsRepository.findById(1).orElseGet(() -> new Details("sam@tidigt.com", "Sam Tidigt", LocalDate.of(1981, 2, 20)));
        Details details2 = detailsRepository.findById(2).orElseGet(() -> new Details("stig@ner.com", "Stig Ner", LocalDate.of(1981, 2, 20)));
        Details finalDetails1 = details1;
        Details finalDetails2 = details2;
        /*
        details1 = detailsRepository.save(details1);
        details2 = detailsRepository.save(details2);
        /**/
        System.out.println("details1: " + details1.toString());
        System.out.println("details2: " + details2.toString());


        AppUser appUser1 = appUserRepository.findById(1).orElseGet(() -> new AppUser("samtid", "pass", LocalDate.now(), finalDetails1));
        AppUser appUser2 = appUserRepository.findById(2).orElseGet(() -> new AppUser("stiner", "pass", LocalDate.now(), finalDetails2));
        AppUser finalAppUser1 = appUser1;
        AppUser finalAppUser2 = appUser2;
        /*
        appUser1 = appUserRepository.save(finalAppUser1);
        appUser2 = appUserRepository.save(finalAppUser2);
        /**/
        System.out.println("appuser1: " + appUser1.toString());
        System.out.println("appuser2: " + appUser2.toString());


        Optional<Book> book1Opt = bookRepository.findById(1);
        Optional<Book> book2Opt = bookRepository.findById(2);

        Book book1 = book1Opt.orElseGet(() -> {
            Book newBook = new Book("1223416660", "The Hobbit", 30);
            return bookRepository.save(newBook);
        });
        Book book2 = book2Opt.orElseGet(() -> {
            Book newBook = new Book("2342352134", "1984", 30);
            return bookRepository.save(newBook);
        });
        //Book finalBook1 = book1;
        //Book finalBook2 = book2;
        System.out.println("book1: " + book1.toString());
        System.out.println("book2: " + book2.toString());



        BookLoan bookLoan1 = bookLoanRepository.findById(1).orElseGet(() -> new BookLoan(LocalDate.now(), false, finalAppUser1, book1));
        BookLoan bookLoan2 = bookLoanRepository.findById(2).orElseGet(() -> new BookLoan(LocalDate.now(), false, finalAppUser2, book2));
        /* */
        bookLoan1 = bookLoanRepository.save(bookLoan1);
        bookLoan2 = bookLoanRepository.save(bookLoan2);
        /**/
        System.out.println("bookLoan1: " + bookLoan1.toString());
        System.out.println("bookLoan2: " + bookLoan2.toString());


        Set<Book> booksWritten1 = new HashSet<>();
        booksWritten1.add(book1);
        Set<Book> booksWritten2 = new HashSet<>();
        booksWritten2.add(book2);
        Author author1 = authorRepository.findById(1).orElseGet(() -> new Author("John", "Tolkien", booksWritten1));
        Author author2 = authorRepository.findById(2).orElseGet(() -> new Author("George", "Orwell", booksWritten2));
        /* */
        author1 =  authorRepository.save(author1);
        author2 =  authorRepository.save(author2);
        /* */
        System.out.println("author1: " + author1.toString());
        System.out.println("author2: " + author2.toString());


    }

    private Book fetchBook(int id, Book book) {
        Optional<Book> book1Opt = bookRepository.findById(id);

        Book book1 = book1Opt.orElseGet(() -> {
            Book newBook = book;
            return bookRepository.save(newBook);
        });
        System.out.println("book1: " + book1.toString());
        return newBook;
    }
}
