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

//        System.out.println("místnost 3 má" + room3.getPricePerNight()+"ano");
//endregions

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

//region Bookings
        Booking booking1 = new Booking(room1,
                guest1,
                LocalDate.of(2021,7,15),
                LocalDate.of(2021,7,24),
                "pracovní"
        );


//        System.out.println("místnost 3 má" + booking1.getGuest().getGuestName()+"ano");
//endregion

    List<Booking> listOfbookings = new ArrayList<>();

    listOfbookings.add(booking1);

    System.out.println("Pokoj číslo "
                    +listOfbookings.get(0).getRoom().getRoomNumber()
                    +" rezervován od "
                    +listOfbookings.get(0).getStartDate()
                    +" do "
                    +listOfbookings.get(0).getEndDate()
                    +" na jméno "
                    +listOfbookings.get(0).getGuest().getGuestName()
            );






    }


}