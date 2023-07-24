package sample.cafekiosk.unit

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import sample.cafekiosk.unit.beverage.Americano
import sample.cafekiosk.unit.beverage.Beverage
import sample.cafekiosk.unit.beverage.Latte
import java.time.LocalDateTime

class CafeKioskTest {

    @Test
    @DisplayName("음료 1개를 추가하면 주문 목록에 담긴다")
    fun add() {

        val cafeKiosk = CafeKiosk()
        cafeKiosk.add(Americano())

        println("음료 수: ${cafeKiosk.beverages.size}")
        println("음료 이름: ${cafeKiosk.beverages.get(0).name}")


    }

    @Test
    fun add2(){
        val cafeKiosk = CafeKiosk()
        cafeKiosk.add(Americano())

        assertThat(cafeKiosk.beverages).hasSize(1)
//        assertThat(cafeKiosk.beverages.size).isEqualTo(1)
        assertThat(cafeKiosk.beverages.get(0).name).isEqualTo("americano")
    }

    @Test
    fun addSeveralBeverage(){
        val cafeKiosk = CafeKiosk()
        val americano = Americano()
        cafeKiosk.add(americano, 2)
        assertThat(cafeKiosk.beverages).hasSize(2)
        assertThat(cafeKiosk.beverages.get(0)).isEqualTo(americano)
        assertThat(cafeKiosk.beverages.get(0)).isEqualTo(americano)
    }

    @Test
    fun addZeroBeverage(){
        val cafeKiosk = CafeKiosk()
        val americano = Americano()

        assertThatThrownBy { cafeKiosk.add(americano, 0) }
            .isInstanceOf(IllegalArgumentException::class.java)

    }

    @Test
    fun remove() {
        val cafeKiosk = CafeKiosk()
        val americano = Americano()
        cafeKiosk.add(americano)

        assertThat(cafeKiosk.beverages).hasSize(1)

        cafeKiosk.remove(americano)
        assertThat(cafeKiosk.beverages).hasSize(0)

    }

    @Test
    fun clear() {
        val cafeKiosk = CafeKiosk()
        val americano = Americano()
        val latte = Latte()
        cafeKiosk.add(americano)
        cafeKiosk.add(latte)
        assertThat(cafeKiosk.beverages).hasSize(2)

        cafeKiosk.clear()
        assertThat(cafeKiosk.beverages).hasSize(0)
    }

    @Test
    fun calculate() {
        val cafeKiosk = CafeKiosk()
        val americano = Americano()
        val latte = Latte()
        cafeKiosk.add(americano)
        cafeKiosk.add(latte)

        val totalPrice = cafeKiosk.getTotalPrice()

        assertThat(totalPrice).isEqualTo(8500)


    }

    @Test
    fun createOrderWithCurrentTime() {
        val cafeKiosk = CafeKiosk()
        val americano = Americano()
        cafeKiosk.add(americano)

        val order = cafeKiosk.createOrder()

        assertThat(order.beverages).hasSize(1)
        assertThat(order.beverages.get(0)).isEqualTo(americano)
        assertThat(order.beverages.get(0)).isInstanceOf(Beverage::class.java)

    }
    @Test
    fun createOrderWithRandomTime() {
        val cafeKiosk = CafeKiosk()
        val americano = Americano()
        cafeKiosk.add(americano)

        val order = cafeKiosk.createOrder(LocalDateTime.of(2023, 7, 23, 10, 0))

        assertThat(order.beverages).hasSize(1)
        assertThat(order.beverages.get(0)).isEqualTo(americano)
        assertThat(order.beverages.get(0)).isInstanceOf(Beverage::class.java)

    }
    @Test
    fun createOrderOutsideTime() {
        val cafeKiosk = CafeKiosk()
        val americano = Americano()
        cafeKiosk.add(americano)

        val time = LocalDateTime.of(2023, 7, 23, 9, 0)
        assertThatThrownBy { cafeKiosk.createOrder(time) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("")
    @Test
    fun Test() {
        //given


        //when


        //then

    }
}