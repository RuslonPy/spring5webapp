package guru.springframework.spring5webapp.spring5webapp.controllers;

import guru.springframework.spring5webapp.spring5webapp.repositories.AuthorRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepositories authorRepositories;

    public AuthorController(AuthorRepositories authorRepositories) {
        this.authorRepositories = authorRepositories;
    }

    @RequestMapping("/authors")
    public String getAuthor(Model model) {
        model.addAttribute("authors", authorRepositories.findAll());
        return "authors";
    }
}
