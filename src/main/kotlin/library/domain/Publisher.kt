package library.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToMany
import javax.persistence.OneToMany

@Entity
class Publisher(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    val name : String,
//    val addressLine1 : String? = null,
//    val city : String? = null,
//    val state : String? = null,
//    val zip : String? = null,
    @OneToMany
    @JoinColumn(name = "publisher_id")
    val books : MutableSet<Book> = mutableSetOf()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Publisher

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Publisher(id=$id, name='$name', books=${books.map {it.id to it.title }})"
    }


}