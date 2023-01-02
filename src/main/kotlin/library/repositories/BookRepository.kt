package library.repositories

import library.domain.Book
import org.springframework.data.repository.CrudRepository

interface BookRepository:CrudRepository<Book, Long> {
}