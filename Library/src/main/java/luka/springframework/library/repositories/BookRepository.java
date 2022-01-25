package luka.springframework.library.repositories;

import luka.springframework.library.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
