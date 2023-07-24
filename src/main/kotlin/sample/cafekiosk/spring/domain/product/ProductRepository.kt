package sample.cafekiosk.spring.domain.product

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sample.cafekiosk.spring.api.service.product.response.ProductResponse

@Repository
interface ProductRepository : JpaRepository<Product, Long>{


    fun findAllByProductSellingTypeIn(sellingTypeList: List<ProductSellingType>): List<Product>
}