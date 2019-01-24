package br.com.onboardingspring.repositories

import br.com.onboardingspring.model.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, String> {
    fun existsByName(name: String): Boolean
}
