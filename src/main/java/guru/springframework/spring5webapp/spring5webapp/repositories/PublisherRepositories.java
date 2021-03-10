package guru.springframework.spring5webapp.spring5webapp.repositories;

import guru.springframework.spring5webapp.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepositories extends CrudRepository<Publisher, Long> {
}
