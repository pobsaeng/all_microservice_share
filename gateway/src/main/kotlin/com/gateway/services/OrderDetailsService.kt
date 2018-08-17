package com.gateway.services

import com.gateway.models.Orders
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import com.gateway.models.OrderDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.util.MultiValueMap
import org.springframework.util.LinkedMultiValueMap



@Service
class OrderDetailsService {

    fun create(orderDetails: OrderDetails): ResponseEntity<OrderDetails>? {
        val url = "http://localhost:8061/create"
        val entity = HttpEntity<OrderDetails>(orderDetails)
        val result = RestTemplate().exchange(url, HttpMethod.POST, entity, OrderDetails::class.java)
        return result
    }

    fun getOrderId(orderId: Int?, productId: Int?): ResponseEntity<OrderDetails> {
        val url = "http://localhost:8061/findBookInCart"

        val map = LinkedMultiValueMap<String, Int>()
        map.add("orderId", orderId)
        map.add("bookId", productId)
        val entity = HttpEntity<MultiValueMap<String, Int>>(map)
        val result = RestTemplate().exchange(url, HttpMethod.POST, entity, OrderDetails::class.java)

        return result
    }
}