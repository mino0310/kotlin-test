package sample.cafekiosk.spring.api.controller.product

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import sample.cafekiosk.spring.api.service.ProductService
import sample.cafekiosk.spring.api.service.product.response.ProductResponse
import sample.cafekiosk.spring.domain.product.Product


@RestController
class ProductController (
    val productService: ProductService
        ) {

    @GetMapping("/api/v1/products/selling")
    fun getSellingProducts(): List<ProductResponse> {
        return productService.getSellingProducts()
    }
}