package library.domain

import javax.persistence.*

@Entity
class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long?,

    val title:String,
    val isbn:String,

    @ManyToMany
    @JoinTable(name = "author_book",
    joinColumns = [JoinColumn(name = "book_id")],
    inverseJoinColumns = [JoinColumn(name = "author_id")])
    val authors: MutableSet<Author> = mutableSetOf(),

    @ManyToOne
    val publisher: Publisher
)
{



    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Book(id=$id, title='$title', isbn='$isbn', authors=$authors, publisher=$publisher)"
    }


}