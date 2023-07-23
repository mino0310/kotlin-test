package sample.cafekiosk.unit.order

import sample.cafekiosk.unit.beverage.Beverage
import java.time.LocalDateTime

class Order (val orderDateTime: LocalDateTime, val beverages : ArrayList<Beverage>){

}