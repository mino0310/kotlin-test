package sample.cafekiosk.spring.domain.product

import jakarta.persistence.*
import lombok.AccessLevel
import lombok.NoArgsConstructor
import sample.cafekiosk.spring.domain.BaseEntity
import java.time.LocalDateTime


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
open class Product (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) open val id : Long,
    open val phoneNumber : String,
    @Enumerated(value = EnumType.STRING)
    open val productType: ProductType,
    @Enumerated(value = EnumType.STRING)
    open val productSellingType: ProductSellingType,
    open val name : String,
    open val price : Int,
) : BaseEntity() {



}