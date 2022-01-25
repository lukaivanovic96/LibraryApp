package luka.springframework.library.repositories;

import luka.springframework.library.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
