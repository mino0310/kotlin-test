package sample.cafekiosk.spring.domain.product

import lombok.RequiredArgsConstructor


@RequiredArgsConstructor
enum class ProductType (private val text: String){

    HANDMADE("제조 음료"),
    BOTTLE("병 음료"),
    BAKERY("베이커리");
}