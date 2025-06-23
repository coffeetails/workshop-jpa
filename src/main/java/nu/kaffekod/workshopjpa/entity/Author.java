package nu.kaffekod.workshopjpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

/*
[x] TODO Add method(s) in Book and / or Author to add and remove Books/Authors
*/

@Entity
public @Data class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Book> writtenBooks;

    public Author(String firstName, String lastName, Set<Book> writtenBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.writtenBooks = writtenBooks;
    }

    public Author() {
    }

    public void addWrittenBook(Book book) {
        if(writtenBooks.contains(book)) {
            System.out.println("Woops, that book already exists");
        } else {
            writtenBooks.add(book);
        }
    }
    public void removeWrittenBook(Book book) {
        writtenBooks.remove(book);
    }

}
