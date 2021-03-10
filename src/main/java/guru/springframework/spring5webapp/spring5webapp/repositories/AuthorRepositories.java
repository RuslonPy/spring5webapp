package guru.springframework.spring5webapp.spring5webapp.repositories;

import guru.springframework.spring5webapp.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepositories extends CrudRepository<Author, Long> {

}
