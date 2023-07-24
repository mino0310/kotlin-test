package sample.cafekiosk.spring.api.service.product.response

import jakarta.persistence.*
import lombok.Builder
import sample.cafekiosk.spring.domain.product.Product
import sample.cafekiosk.spring.domain.product.ProductSellingType
import sample.cafekiosk.spring.domain.product.ProductType


data class ProductResponse (
     val phoneNumber : String? = "",
     val productType: ProductType? = null,
     val productSellingType: ProductSellingType? = null,
     val name : String? = null,
     val price : Int? = null
    ){

    companion object {
        fun of(product: Product): ProductResponse {
            return ProductResponse(
                phoneNumber = product.phoneNumber,
                productType = product.productType,
                productSellingType = product.productSellingType,
                name = product.name,
                price = product.price
            )
        }
    }

}