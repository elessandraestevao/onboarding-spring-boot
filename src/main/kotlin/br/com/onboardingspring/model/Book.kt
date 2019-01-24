package br.com.onboardingspring.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Book(
    val name: String,
    val price: Double,

    @Id //JavaxPerssitence
    val id: String = UUID.randomUUID().toString()
)