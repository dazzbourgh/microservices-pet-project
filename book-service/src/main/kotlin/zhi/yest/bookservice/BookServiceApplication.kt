package zhi.yest.bookservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.security.access.annotation.Secured
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.GetMapping

@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/books")
@EnableResourceServer
class BookServiceApplication {
    private val bookList = listOf(
            Book(1L, "Baeldung goes to the market", "Tim Schimandle"),
            Book(2L, "Baeldung goes to the park", "Slavisa")
    )

    @GetMapping("")
    @Secured("ROLE_USER")
    fun findAllBooks(): List<Book> {
        return bookList
    }

    @GetMapping("/{bookId}")
    @Secured("ROLE_USER")
    fun findBook(@PathVariable bookId: Long): Book? {
        return bookList.first { it.id == bookId }
    }
}

fun main(args: Array<String>) {
    runApplication<BookServiceApplication>(*args)
}
