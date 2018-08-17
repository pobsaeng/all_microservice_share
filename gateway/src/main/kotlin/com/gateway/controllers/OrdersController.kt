package com.gateway.controllers
import com.gateway.models.OrderDetails
import com.gateway.models.Orders
import com.gateway.services.BookService
import com.gateway.services.OrderDetailsService
import com.gateway.services.OrdersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpEntity

@RestController
class OrdersController {
//    @PostMapping("/addToOrder") fun addToOrder(@RequestBody order: Orders) = OrdersService(order).create()
    @Autowired
    lateinit var bookService: BookService
    @Autowired
    lateinit var orderDetailsService: OrderDetailsService

    @GetMapping("/addToOrder")
    fun addToOrder() {
        val order = Orders(null, true, 1)

        OrdersService().create(order, bookService, orderDetailsService)
        val orderDetails = orderDetailsService.create(OrderDetails(null, 1, 2, 2))
    }
}