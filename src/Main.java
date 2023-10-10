import com.engeto.rooms.Booking;
import com.engeto.rooms.Guest;
import com.engeto.rooms.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

//region Room
        Room room1 = new Room(
                1,
                1,
                true,
                true,
                1000
        );

        Room room2 = new Room(
                2,
                1,
                true,
                true,
                1000
        );

        Room room3 = new Room(
                3,
                3,
                false,
                true,
                2400
        );

        System.out.println(room1);
        System.out.println(room2);
        System.out.println(room3);


//endregion

//region Guest
        Guest guest1 = new Guest(
                "Adéla Malíková",
                LocalDate.of(1993,3,13)
                );
        Guest guest2 = new Guest(
                "Jan Dvořáček",
                LocalDate.of(1995,5,5)
                );


//endregions

//region Guest List
    ArrayList<Guest> guestList1 = new ArrayList<>();
//    guestList1.add(guest1);       // tohohle hosta už nechci, je součástí arraylistu
    guestList1.add(guest2);


//endregion

//region Bookings
        Booking booking1 = new Booking(room1,
                guest1,
                LocalDate.of(2021,7,19),
                LocalDate.of(2021,7,26),
                "pracovní"
        );

        Booking booking2 = new Booking(guest1,guestList1,
                room3,
                LocalDate.of(2021,7,19),
                LocalDate.of(2021,7,26),
                "pracovní");

//endregion


//region Booking List

    List<Booking> listOfbookings = new ArrayList<>();
    listOfbookings.add(booking1);
    listOfbookings.add(booking2);
//endregion

//region Puvodni
//    int i = 0;
//    for (Booking booking: listOfbookings) {
//        if (guestList1.size() > 2){
//        System.out.println((i+1)+": Pokoj číslo "
//                +listOfbookings.get(i).getRoom().getRoomNumber()
//                +" je rezervován od "
//                +listOfbookings.get(i).getStartDate()
//                +" do "
//                +listOfbookings.get(i).getEndDate()
//                +" na jméno "
//                +guestList1.get(0).getGuestName()
//                );
//        }
//        else
//        {
//        System.out.println((i+1)+": Pokoj číslo "
//                +listOfbookings.get(i).getRoom().getRoomNumber()
//                +" je rezervován od "
//                +listOfbookings.get(i).getStartDate()
//                +" do "
//                +listOfbookings.get(i).getEndDate()
//                +" na jméno "
//                +guestList1.get(0).getGuestName()
//                +
//                " a "
//                + guestList1.get(i).getGuestName()
//                );
//        }
//        ++i;
//    }
//endregion

//region Novy
        int i = 0; // místo i jde použít booking pro lepší přehlednost
    for (Booking booking: listOfbookings) {
        System.out.print((i+1)+": Pokoj číslo "
                +booking.getRoom().getRoomNumber()
                +" je rezervován od "
                +booking.getStartDate()
                +" do "
                +booking.getEndDate()
                +" na jméno "
                +booking.getGuest().getGuestName()
        );
        for (Guest guest: booking.getGuestList()) {
            System.out.print(" a "
                    + guest.getGuestName());
        }
        System.out.println();
//        if (i > 0){
//            System.out.println(" a "
//                    + guestList1.get(i).getGuestName());


//        }
        ++i;
    }
//endregion


    }


}