package org.example.kt

class ReservationSystem {
    private val reservations  = mutableListOf<Reservation>()
    private var nextId = 1

    fun makeReservation(name: String, date: String, numberOfGuests: Int): Reservation {

        val reserv = Reservation(nextId++,name,date,numberOfGuests)
        reservations.add(reserv)
        return reserv
    }

    fun getReservation(): List<Reservation>{
        return reservations
    }

    fun getReservationById(id: Int): Reservation?{
        return reservations.find { it.id == id }

    }

    /**
     * This method cancel the reservation by id
     * @return true if the reservation was removed successfully
     */
    fun cancelReservation(id: Int):Boolean{
        val reservation = getReservationById(id)
        return reservations.remove(reservation)

    }
}