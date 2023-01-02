package library.bootstrap

import library.domain.Author
import library.domain.Book
import library.domain.Publisher
import library.repositories.AuthorRepository
import library.repositories.BookRepository
import library.repositories.PublisherRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class BootStrapData: CommandLineRunner {

    @Autowired
    lateinit var authorRepository: AuthorRepository

    @Autowired
    lateinit var bookRepository: BookRepository

    @Autowired
    lateinit var publisherRepository: PublisherRepository


    override fun run(vararg args: String?) {
//        println("сообщение из рана")
        val ababa = Publisher(null, name = "Ababagalamaga")
        val eric = Author(null, "Eric", "Evans")
        val ddd = Book(id = null, title = "Domain Driven Design", isbn = "123123", publisher = ababa)
        publisherRepository.save(ababa)
        eric.books.add(ddd)
        ddd.authors.add(eric)
        ababa.books.add(ddd)
        authorRepository.save(eric)
        bookRepository.save(ddd)
        publisherRepository.save(ababa)


        val rod = Author(null, "Rod", "Jhonson")
        val noEJB = Book(null, "J2EE Development without EJB", "1242353245", publisher = ababa)
        rod.books.add(noEJB)
        ababa.books.add(noEJB)
        noEJB.authors.add(rod)
        authorRepository.save(rod)
        bookRepository.save(noEJB)
        publisherRepository.save(ababa)

        println("Started in BootStrap")
        println("Number of books: ${bookRepository.count()}")
        println("Number of publisher's books: ${publisherRepository.count()}")
        println(ababa.toString())

//        println("сообщение из конца рана")
    }


}