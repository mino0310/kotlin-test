package sample.cafekiosk.unit

import org.springframework.cglib.core.Local
import sample.cafekiosk.unit.beverage.Beverage
import sample.cafekiosk.unit.order.Order
import java.time.LocalDateTime
import java.time.LocalTime


class CafeKiosk {

    companion object {
        val SHOP_OPEN_TIME: LocalTime = LocalTime.of(10, 0)
        val SHOP_CLOSE_TIME: LocalTime = LocalTime.of(22, 0)
    }

    val beverages : ArrayList<Beverage> = arrayListOf<Beverage>()

    fun add(beverage: Beverage) {
        this.beverages.add(beverage)
    }

    fun add(beverage: Beverage, cnt: Int) {

        if (cnt <= 0) {
            throw IllegalArgumentException("음료는 1잔 이상부터 주문하실 수 있습니다")
        }

        for (i in 0 until cnt){
            this.beverages.add(beverage)
        }

    }

    fun remove(beverage: Beverage) {
        this.beverages.remove(beverage)
    }

    fun clear(){
        beverages.clear()
    }

    fun getTotalPrice(): Int {
        var totalPrice = 0;

//        beverages.forEach { totalPrice += it.price }
        beverages.onEach { totalPrice += it.price }


        return totalPrice;
    }

    fun createOrder(): Order{

        val currentDateTime = LocalDateTime.now()
        val currentTime = currentDateTime.toLocalTime()

        if (currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)) {
            throw IllegalArgumentException("주문 시간이 아닙니다.")
        }

        return Order(LocalDateTime.now(), this.beverages)
    }
    fun createOrder(currentDateTime: LocalDateTime): Order{
        val currentTime = currentDateTime.toLocalTime()
        if (currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)) {
            throw IllegalArgumentException("주문 시간이 아닙니다.")
        }
        return Order(LocalDateTime.now(), this.beverages)
    }
}