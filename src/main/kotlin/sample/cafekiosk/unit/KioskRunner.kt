package sample.cafekiosk.unit

import sample.cafekiosk.unit.beverage.Americano
import sample.cafekiosk.unit.beverage.Latte

class KioskRunner

fun main(args: Array<String>) {
    val cafeKiosk: CafeKiosk = CafeKiosk()
    cafeKiosk.add(Americano())
    cafeKiosk.add(Latte())
    val totalPrice = cafeKiosk.getTotalPrice()
    println("총 주문가격 = $totalPrice")

}

