import com.engeto.rooms.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.engeto.rooms.BookingManager.*;


public class Main {
    public static void main(String[] args) {
//region Úkol lekce 2

        //region Room - Vytvoření a vypsání místností
        Room room1 = new Room(1, 1, true, true, 1000);

        Room room2 = new Room(2, 1, true, true, 1000);

        Room room3 = new Room(3, 3, false, true, 2400);


        //endregion

        //region Guest - Vytvoření hostů dle zadání lekce 2
        Guest guest1 = new Guest("Adéla", "Malíková", LocalDate.of(1993, 3, 13));
        Guest guest2 = new Guest("Jan", "Dvořáček", LocalDate.of(1995, 5, 5));
        //endregion

        //region Guest List - Vytvoření listu pro další hosty (1. host se parametr bookingu)
        ArrayList<Guest> guestList1 = new ArrayList<>();
        guestList1.add(guest2);


        //endregion

        //region Bookings - Rezervace dle zadání lekce 2
        Booking booking1 = new Booking(room1, guest1, LocalDate.of(2021, 7, 19), LocalDate.of(2021, 7, 26), vacationType.PRACOVNÍ);

        Booking booking2 = new Booking(room3, guest1, guestList1, LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14), vacationType.PRACOVNÍ);

        //endregion

        //region Booking Lists - Vytvoření seznamu rezervací


        List<Booking> listOfBookings = new ArrayList<>();
        listOfBookings.add(booking1);
        // Ověření, zda-li je pokoj volný - viz BookingManager
        if (isRoomFree(listOfBookings, booking2)) {
            listOfBookings.add(booking2);
        }
        //endregion

        //region Výstup testovací aplikace lekce 2
        System.out.println("\n------Testovací aplikace lekce 2");

        System.out.println("\nVypsání hostů");
        System.out.println(guest1);
        System.out.println(guest2);

        System.out.println("\nVypsání pokojů");

        System.out.println(room1);
        System.out.println(room2);
        System.out.println(room3);

        System.out.println("\nVypsání rezervací");

        for (Booking booking : listOfBookings) {
            System.out.print(listOfBookings.indexOf(booking) + 1
                    + ": Pokoj číslo " + booking.getRoom().getRoomNumber()
                    + " je rezervován od " + booking.formattedStartDate()
                    + " do " + booking.formattedEndDate()
                    + " na jméno " + booking.getGuest().getFirstName() + " "
                    + booking.getGuest().getLastName());
            for (Guest guest : booking.getGuestList()) {
                System.out.print(" a " + guest.getFirstName() + guest.getLastName());
            }
            System.out.println();
        }


        //endregion
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");

//endregion

//region Úkol lekce 3

        //region Guest - Vytvoření hostů dle zadání lekce 3

        Guest hotelGuest1 = new Guest("Karel", "Dvořák", LocalDate.of(1990, 5, 15));
        Guest hotelGuest2 = new Guest("Karel", "Dvořák", LocalDate.of(1979, 1, 3));
        Guest hotelGuest3 = new Guest("Karolína", "Tmavá", LocalDate.of(1985, 3, 20));
        //endregion

        //region Bookings - Rezervace dle zadání lekce 3
        List<Booking> listOfBookings2 = new ArrayList<>();
        Booking hotelBooking1 = new Booking(room3, hotelGuest1, LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 7), vacationType.PRACOVNÍ);
        Booking hotelBooking2 = new Booking(room2, hotelGuest2, LocalDate.of(2023, 7, 18), LocalDate.of(2023, 7, 21), vacationType.REKREAČNÍ);
        Booking hotelBooking4 = new Booking(room3, hotelGuest3, LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 31), vacationType.PRACOVNÍ);
        listOfBookings2.add(hotelBooking1);
        listOfBookings2.add(hotelBooking2);

        for (int i = 0; i <= 18; i += 2) {
            Booking hotelBooking = new Booking(room2, hotelGuest3, (LocalDate.of(2023, 8, 1)).plusDays(i), (LocalDate.of(2023, 8, 2)).plusDays(i), vacationType.REKREAČNÍ);
            listOfBookings2.add(hotelBooking);
        }

        listOfBookings2.add(hotelBooking4);
        //endregion
        System.out.println("\n------Testovací aplikace lekce 3");
        BookingManager bookingsList = new BookingManager();

        //Volání metody fillBookings pro naplnění listu hostů řídy BookingManager
        fillBookings(bookingsList, listOfBookings2);

        System.out.println("\nVypsání seznamu rezervací:");
        printBookings(bookingsList.getBookings());

        //region Výstup testovací aplikace lekce 3
        int bookingIndex = 1;
        System.out.println("\nVypsání rezervace s indexem " + bookingIndex + ":");
        System.out.println(bookingsList.getBooking(bookingIndex));

        System.out.print("\nPočet pracovních rezervací: ");
        System.out.println(bookingsList.getNumberOfWorkingBookings());

        System.out.print("\nPrůměrný počet hostů na rezervaci: ");
        System.out.println(bookingsList.getAverageGuests());


        int numberOfRecreationalBookings = 8;
        System.out.println("\nPrvních " + numberOfRecreationalBookings + " rekreačních pobytů: ");
        printRecreationalBookings(bookingsList.getBookings(), numberOfRecreationalBookings);

        System.out.println("\nStatistiky počtů hostů: ");
        printGuestStatistics(bookingsList.getBookings());

        int bookingLengthIndex = 0;
        System.out.print("\nDélka rezervace s indexem " + bookingLengthIndex + ": ");
        System.out.println(bookingsList.getBooking(bookingLengthIndex).getBookingLength());

        int bookingPriceIndex = 1;
        System.out.print("\nCena rezervace s indexem " + bookingPriceIndex + ": ");
        System.out.println(bookingsList.getBooking(bookingPriceIndex).getPrice());


        bookingsList.clearBookings();
        //endregion

//endregion
    }

    //Naplnění booking Listu vytvořenýma rezervacema
    public static void fillBookings(BookingManager manager, List<Booking> listOfBookings) {
        for (Booking booking : listOfBookings) {
            manager.addBooking(booking);
        }

    }

    //Statistika rezervací s požadovanými počty hostů
    public static void printGuestStatistics(List<Booking> listOfBookings) {
        int oneguest = 0;
        int twoguests = 0;
        int moreguests = 0;
        for (Booking booking : listOfBookings) {

            if (booking.getNumberOfGuests() == 1) {
                oneguest++;
            } else if (booking.getNumberOfGuests() == 2) {
                twoguests++;
            } else if (booking.getNumberOfGuests() > 2) {
                moreguests++;
            }
        }
        System.out.println("Počet rezervací s jedním hostem: " + oneguest);
        System.out.println("Počet rezervací se dvěma hosty: " + twoguests);
        System.out.println("Počet rezervací s více než dvěma hosty: " + moreguests);
    }


}
