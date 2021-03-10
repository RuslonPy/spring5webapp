package guru.springframework.spring5webapp.spring5webapp.controllers;

import guru.springframework.spring5webapp.spring5webapp.model.Book;
import guru.springframework.spring5webapp.spring5webapp.repositories.BookRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepositories bookRepositories;

    public BookController(BookRepositories bookRepositories) {
        this.bookRepositories = bookRepositories;
    }

    @RequestMapping("/books")
    public String getBook(Model model) {
        model.addAttribute("books", bookRepositories.findAll());
        return "books";
    }
}
