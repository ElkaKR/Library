package library.repositories

import library.domain.Publisher
import org.springframework.data.repository.CrudRepository

interface PublisherRepository:CrudRepository<Publisher, Long> {
}