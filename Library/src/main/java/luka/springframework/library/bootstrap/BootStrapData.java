package luka.springframework.library.bootstrap;

import luka.springframework.library.domain.Author;
import luka.springframework.library.domain.Book;
import luka.springframework.library.domain.Publisher;
import luka.springframework.library.repositories.AuthorRepository;
import luka.springframework.library.repositories.BookRepository;
import luka.springframework.library.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric=new Author("Eric","Evans");
        Book ddd=new Book("Domain Driven Design","213123");
        Publisher p=new Publisher("asd","asd");



        eric.getBooks().add(ddd);
        bookRepository.save(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(p);
        p.getBooks().add(ddd);

        authorRepository.save(eric);

        publisherRepository.save(p);


        Author rod=new Author("Rod", "Johnson");
        Book noEJB=new Book("J2EE Development without EJB","34245");
        bookRepository.save(noEJB);


        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(p);
        p.getBooks().add(noEJB);

        authorRepository.save(rod);
        publisherRepository.save(p);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of pub "+publisherRepository.count());
        System.out.println("Pub number of books"+p.getBooks().size());

    }
}
