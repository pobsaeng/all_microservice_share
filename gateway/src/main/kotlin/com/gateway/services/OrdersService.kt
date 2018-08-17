package com.gateway.services

import com.gateway.models.OrderDetails
import com.gateway.models.Orders
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.client.RestTemplate

@Service
class OrdersService {

    fun create(order: Orders,
               bookService: BookService,
               orderDetailsService: OrderDetailsService): Orders? {
        val bookId = 3

        val url = "http://localhost:8089/create"
        val entity = HttpEntity<Orders>(order)
        val _order = RestTemplate().exchange(url, HttpMethod.POST, entity, Orders::class.java).body

        val book = bookService.getBookById(bookId)
        println(book!!.id)

//        val orderDetails = orderDetailsService.getOrderId(_order!!.id!!.toInt(), book!!.id!!.toInt())
//        println(orderDetails)
//        orderDetailsService.create(orderDetails)

        return null
    }
}