package library.controllers

import library.repositories.AuthorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AuthorController {

    @Autowired
    lateinit var authorRepository: AuthorRepository

    @GetMapping("/authors")
    fun getAuthors(model: Model):String {
        model.addAttribute("authors", authorRepository.findAll())
        return ("authors/list")
    }
}