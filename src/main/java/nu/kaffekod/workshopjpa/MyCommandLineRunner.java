package nu.kaffekod.workshopjpa;

import nu.kaffekod.workshopjpa.entity.*;
import nu.kaffekod.workshopjpa.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashSet;
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

    @Transactional // I don't recommend forgetting to add this lil shit
    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Application started ===");
        /*          It's dangerous to go alone! Take this           *\
        \*                            🗡️                            */

        Details details1 = detailsRepository.findById(1).orElseGet(() ->
            detailsRepository.save(new Details("sam@tidigt.com", "Sam Tidigt", LocalDate.of(1981, 2, 20) ))
        );
        System.out.println("→ details1: " + details1);

        Details details2 = detailsRepository.findById(2).orElseGet(() ->
            detailsRepository.save(new Details("stig@ner.com", "Stig Ner", LocalDate.of(1991, 2, 20) ))
        );
        System.out.println("→ details2: " + details2);


        Details finalDetails2 = details1;
        AppUser appUser1 = appUserRepository.findById(1).orElseGet(() ->
                appUserRepository.save(new AppUser("samtid", "pass", LocalDate.now(), finalDetails2))
        );
        System.out.println("→ appuser1: " + appUser1);
        Details finalDetails3 = details2;
        AppUser appUser2 = appUserRepository.findById(2).orElseGet(() ->
                appUserRepository.save(new AppUser("stiner", "pass", LocalDate.now(), finalDetails3))
        );
        System.out.println("→ appuser2: " + appUser2);


        Book book1 = fetchOrSaveBook("1223416660", new Book("1223416660", "The Hobbit", 30));
        System.out.println("→ book1: " + book1);
        Book book2 = fetchOrSaveBook("2342352134", new Book("2342352134", "1984", 30));
        System.out.println("→ book2: " + book2);


        BookLoan bookLoan1 = fetchOrSaveBookLoan(1, new BookLoan(LocalDate.now(), false, appUser1, book1));
        System.out.println("→ bookLoan1: " + bookLoan1.toString());
        BookLoan bookLoan2 = fetchOrSaveBookLoan(2, new BookLoan(LocalDate.now(), false, appUser2, book2));
        System.out.println("→ bookLoan2: " + bookLoan2.toString());


        book1 = fetchOrSaveBook("1223416660", new Book("1223416660", "The Hobbit", 30));
        System.out.println("→ book1 " + book1);
        book2 = fetchOrSaveBook("2342352134", new Book("2342352134", "1984", 30));
        System.out.println("→ book2 " + book2);


        Set<Book> booksWritten11 = new HashSet<>();
        booksWritten11.add(book1);
        System.out.println("→ booksWritten1" + booksWritten11);
        Set<Book> booksWritten22 = new HashSet<>();
        booksWritten22.add(book2);
        System.out.println("→ booksWritten2" + booksWritten22);

        Author author1 = fetchOrSaveAuthor(1, new Author("John", "Tolkien", booksWritten11));
        System.out.println("→ author1: " + author1.toString());
        Author author2 = fetchOrSaveAuthor(2, new Author("George", "Orwell", booksWritten22));
        System.out.println("→ author2: " + author2.toString());

        System.out.println(" === update appuser ===");

        book1 = fetchOrSaveBook("1223416660", new Book("1223416660", "The Hobbit", 30));
        System.out.println("→ book1 " + book1);
        bookLoan1 = fetchOrSaveBookLoan(1, new BookLoan(LocalDate.now(), false, appUser1, book1));
        System.out.println("→ bookloan1: " + bookLoan1);
        details1 = detailsRepository.findById(1).orElseGet(() ->
                detailsRepository.save(new Details("sam@tidigt.com", "Sam Tidigt", LocalDate.of(1981, 2, 20) ))
        );
        System.out.println("→ details1: " + details1);
        Details finalDetails1 = details1;
        appUser1 = appUserRepository.findById(1).orElseGet(() ->
                appUserRepository.save(new AppUser("samtid", "pass", LocalDate.now(), finalDetails1))
        );
        System.out.println("→ appuser1: " + appUser1);
        appUser1.setBookLoan(bookLoan1);
        System.out.println("→ appuser1 " + appUser1);


        book2 = fetchOrSaveBook("2342352134", new Book("2342352134", "1984", 30));
        System.out.println("→ book2 " + book2);
        bookLoan2 = fetchOrSaveBookLoan(2, new BookLoan(LocalDate.now(), false, appUser2, book2));
        System.out.println("→ bookLoan2 " + bookLoan2);

        details2 = detailsRepository.findById(2).orElseGet(() ->
                detailsRepository.save(new Details("stig@ner.com", "Stig Ner", LocalDate.of(1991, 2, 20) ))
        );
        System.out.println("→ details2: " + details2);
        Details finalDetails = details2;
        appUser2 = appUserRepository.findById(2).orElseGet(() ->
                appUserRepository.save(new AppUser("stiner", "pass", LocalDate.now(), finalDetails))
        );
        System.out.println("→ appuser2: " + appUser2);
        appUser2.setBookLoan(bookLoan2);
        System.out.println("→ appuser2: " + appUser2);

    }



    private Author fetchOrSaveAuthor(int id, Author author) {
        return authorRepository.findById(id).orElseGet(() -> authorRepository.save(author));
    }
    private Book fetchOrSaveBook(String isbn, Book book) {
        Book foundBook = bookRepository.findByIsbnIgnoreCase(isbn);
        if (foundBook != null) {
            return foundBook;
        } else {
            return bookRepository.save(book);
        }
    }
    private BookLoan fetchOrSaveBookLoan(int id, BookLoan bookLoan) {
        return bookLoanRepository.findById(id).orElseGet(() -> bookLoanRepository.save(bookLoan));
    }

}
