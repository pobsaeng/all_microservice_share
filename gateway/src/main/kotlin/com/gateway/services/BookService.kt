package com.gateway.services

import com.gateway.models.Book
import com.gateway.models.OrderDetails
import com.gateway.models.Orders
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.client.RestTemplate
import org.springframework.http.HttpHeaders
import java.util.*

@Service
class BookService {
    fun getBookById(bookId: Int?): Book? {
        val url = "http://localhost:8088/findByBookId/{id}"
        val params = Collections.singletonMap("id", bookId!!)
        val result = RestTemplate().getForObject(url, Book::class.java, params)
        return result
    }
}