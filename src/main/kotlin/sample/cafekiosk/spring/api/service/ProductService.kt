package sample.cafekiosk.spring.api.service

import org.springframework.stereotype.Service
import sample.cafekiosk.spring.api.service.product.response.ProductResponse
import sample.cafekiosk.spring.domain.product.Product
import sample.cafekiosk.spring.domain.product.ProductRepository
import sample.cafekiosk.spring.domain.product.ProductSellingType


@Service
class ProductService (
    private val productRepository: ProductRepository
        ){


    fun getSellingProducts(): List<ProductResponse> {
        val productList: List<Product> =
            productRepository.findAllByProductSellingTypeIn(ProductSellingType.forDisplay())

        return productList.map { ProductResponse.of(it) }
    }

}