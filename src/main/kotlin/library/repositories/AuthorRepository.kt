package library.repositories

import library.domain.Author
import org.springframework.data.repository.CrudRepository

interface AuthorRepository:CrudRepository<Author, Long> {
}