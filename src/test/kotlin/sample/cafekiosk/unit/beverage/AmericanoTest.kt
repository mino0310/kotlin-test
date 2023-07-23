package sample.cafekiosk.unit.beverage

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class AmericanoTest{

    @Test
    fun getName() {

        val americano = Americano()
        val name = americano.name

        assertThat(name).isEqualTo("americano")

    }
}