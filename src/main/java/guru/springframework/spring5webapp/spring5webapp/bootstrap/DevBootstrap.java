package guru.springframework.spring5webapp.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.spring5webapp.model.Author;
import guru.springframework.spring5webapp.spring5webapp.model.Book;
import guru.springframework.spring5webapp.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.spring5webapp.repositories.AuthorRepositories;
import guru.springframework.spring5webapp.spring5webapp.repositories.BookRepositories;
import guru.springframework.spring5webapp.spring5webapp.repositories.PublisherRepositories;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepositories authorRepositories;
    private BookRepositories bookRepositories;
    private PublisherRepositories publisherRepositories;

    public DevBootstrap(AuthorRepositories authorRepositories, BookRepositories bookRepositories, PublisherRepositories publisherRepositories) {
        this.authorRepositories = authorRepositories;
        this.bookRepositories = bookRepositories;
        this.publisherRepositories = publisherRepositories;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("Foo");

        publisherRepositories.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepositories.save(eric);
        bookRepositories.save(ddd);

        // Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher);
        rod.getBooks().add(noEJB);

        authorRepositories.save(rod);
        bookRepositories.save(noEJB);
    }
}
