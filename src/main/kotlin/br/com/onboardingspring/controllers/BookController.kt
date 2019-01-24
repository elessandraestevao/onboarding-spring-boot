package br.com.onboardingspring.controllers

import br.com.onboardingspring.model.Book
import br.com.onboardingspring.repositories.BookRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/books")
class BookController (
    ///Colocar recebimento do valor no construtor, para garantir que sempre havera esse valor setado
    ///ver de mudar o nome desse val para bookRepository!!!!!
    private val bookRepository: BookRepository
){

    ///forma de fazer com injecao de dependencia
    //@Autowired
    //private lateinit var bookRepository: BookRepository
    //lateinit está aguardando o valor ser setado em algum momento, corre risco de Null Pointer Execption


    private val books = mutableListOf<Book>()

    @GetMapping("/all")
    fun getAllBooks(): List<Book> {
//        return """[
//                {
//                    "name": "Harry Potter",
//                    "price": 6.90
//                }
//                ]"""".trimIndent() ///remove espaços em branco entre as linhas
        //return listOf(Book("Harry Potter", 55.90))
        return bookRepository.findAll()
    }

    @PostMapping("/add")
    fun saveBook(@RequestBody book: Book): ResponseEntity<Book> {
        val savedBook = bookRepository.save(book)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook)
    }

    @GetMapping("/{name}")
    fun existsBook(@PathVariable name: String): Boolean{
        return bookRepository.existsByName(name)
    }

    @GetMapping("/find/{id}")
    fun findBook(@PathVariable id: String): Book{
        return bookRepository.findByIdOrNull(id)
        ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
}