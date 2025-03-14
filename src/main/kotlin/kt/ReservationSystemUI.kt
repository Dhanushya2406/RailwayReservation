package org.example.kt
import java.util.Scanner

class ReservationSystemUI {

    private val reservation = ReservationSystem()

    fun start(){
        val scanner  = Scanner(System.`in`)

        while (true){
            println("1. Make a Reservation")
            println("2. View all Reservation")
            println("3. Cancel Reservation")
            println("4. Exit")

            when(scanner.nextInt()){
                1->{
                    println("Make a Reservation:")
                    scanner.nextLine() // given a line
                    println("Name:")
                    val name = scanner.nextLine()
                    println("Date:")
                    val date = scanner.nextLine()
                    println("Number of Guests:")
                    val numberOfGuests = scanner.nextInt()
                    scanner.nextLine()  // given a line

                    val Reservation = reservation.makeReservation(name,date,numberOfGuests)
                    println("Reservation made with ID ${Reservation.id}")
                }
                2-> {
                    println("View Reservation:")
                    for (r in reservation.getReservation()){
                        println("${r.id} - ${r.name} - ${r.date} - ${r.numberOfGuests}")
                    }
                }
                3->{
                    println("Cancel Reservation")
                    println("Enter the ID:")
                    val id = scanner.nextInt()
                    scanner.nextLine()

                    if (reservation.cancelReservation(id)){
                        println("Reservation cancelled")
                    }else{
                        println("Reservation not found")
                    }
                }
                4-> return
                else -> println("Invalid choice")
            }
            println()
        }
    }
}

fun main(){
    val obj = ReservationSystemUI()
    obj.start()
}