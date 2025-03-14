package jav;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reservation {

    private int id;
    private String name;
    private String date;
    private int numberOfGuests;

    public Reservation(int Id, String Name, String Date, int NumberOfGuests){
        this.id = Id;
        this.name = Name;
        this.date = Date;
        this.numberOfGuests = NumberOfGuests;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }
}


class ReservationSystem{

    private List<Reservation> reservations = new ArrayList<>();
    private int nextId = 1;

    public Reservation makeReservation(String name, String date, int numberOfGuests){

        Reservation newReservation = new Reservation(nextId++,name,date,numberOfGuests);
        reservations.add(newReservation);
        return newReservation;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public Reservation getReservationById(int id){
        for (Reservation reser1: reservations){
            if (reser1.getId() == id){
                return reser1;
            }
        }
        return null;
    }

    public boolean cancelReservation(int id){
        Reservation reser2 = getReservationById(id);
        if (reser2 != null){
            reservations.remove(reser2);
            return true;
        }
        return false;
    }
}

class ReservationSystemUI{
    private ReservationSystem reservation = new ReservationSystem();

    public void start(){
        Scanner scan = new Scanner(System.in);

        while (true){
            System.out.println("Make a Reservation");
            System.out.println("View all Reservation");
            System.out.println("Cancel Reservation");
            System.out.println("Exit");

            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Make a Reservation:");
                    System.out.println("Enter a Name");
                    String name = scan.nextLine();
                    System.out.println("Enter a Date");
                    String date = scan.nextLine();
                    System.out.println("Enter Number of Guests");
                    int numberOfGuests = scan.nextInt();
                    scan.nextLine();

                    Reservation reserv = reservation.makeReservation(name,date,numberOfGuests);
                    System.out.println("Reservation made with ID:" + reserv.getId());
                    break;
                case 2:
                    System.out.println("View all Reservation:");
                    for (Reservation r: reservation.getReservations()){
                        System.out.println(r.getId() +"-"+ r.getName()+ "-"+ r.getDate() +"-"+ r.getNumberOfGuests());
                    }
                    break;
                case 3:
                    System.out.println("Cancel Reservation:");
                    int id = scan.nextInt();
                    scan.nextLine();
                    if (reservation.cancelReservation(id)){
                        System.out.println("Reservation cancelled");
                    }else {
                        System.out.println("Reservation not found");
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ReservationSystemUI obj = new ReservationSystemUI();
        obj.start();
    }
}
