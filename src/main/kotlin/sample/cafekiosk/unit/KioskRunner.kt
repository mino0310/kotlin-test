package sample.cafekiosk.unit

import java.util.Arrays

class KioskRunner

fun main(args: Array<String>) {
    val cafeKiosk: CafeKiosk = CafeKiosk()
    cafeKiosk.add(Americano())
    cafeKiosk.add(Latte())
    val totalPrice = cafeKiosk.getTotalPrice()
    println("총 주문가격 = $totalPrice")
}

