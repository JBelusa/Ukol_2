package com.engeto.rooms;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookingsList = new ArrayList<>();


    public void addBooking(Booking newBooking) {
        bookingsList.add(newBooking);
    }

    //Získání rezervace s požadovaným indexem
    public Booking getBooking(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index musí být kladný");
        } else if (index > bookingsList.size()) {
            throw new IllegalArgumentException("Rezervace s tímto indexem " + index + " neexistuje.");
        }
        return bookingsList.get(index);
    }

    //Získání seznamu rezervací
    public List<Booking> getBookings() {
        return bookingsList;
    }


    //Vymazat seznamu rezervací
    public void clearBookings() {
        bookingsList.clear();
    }

    //Počet pracovních pobytů
    public int getNumberOfWorkingBookings() {
        int numberOfWorkingBookings = 0;
        for (Booking booking : bookingsList) {
            if (booking.getVacationType() == vacationType.PRACOVNÍ) {
                ;
                numberOfWorkingBookings++;
            }
        }
        return numberOfWorkingBookings;
    }

    //Průměrnýpočet hostů na rezervaci
    public double getAverageGuests() {
        int totalGuests = 0;

        for (Booking booking : bookingsList) {
            totalGuests += booking.getNumberOfGuests();
        }
        return (double) totalGuests / bookingsList.size();
    }


    public static boolean isRoomFree(List<Booking> list, Booking rezervace) {

        for (Booking booking : list) {
            if (booking.getRoom().equals(rezervace.getRoom()) & rezervace.getStartDate().isBefore(booking.getEndDate())) {
                System.out.println("Pokoj " + booking.getRoom().getRoomNumber() + " není volný");
                return false;
            }
        }
        return true;
    }

    //Výpis všech rezervací
    public static void printBookings(List<Booking> bookingListToPrint) {
        for (Booking booking : bookingListToPrint) {

            System.out.println(booking.formattedStartDate() + " až "
                    + booking.formattedEndDate() + " " + booking.getGuest().getFirstName()
                    + " " + booking.getGuest().getLastName()
                    + "[" + (1 + booking.getGuestList().size()) + ", " + booking.getRoom().hasSeaView() + "]"
                    + " za " + booking.getPrice() + " Kč");
        }
    }

    //Výpis rekreačních pobytů
    public static void printRecreationalBookings(List<Booking> bookingListToEvaluate, int numberOfBookings) {
        int numberOfRecreationalBookings = 0;
        List<Booking> recreationalBookings = new ArrayList<>();
        for (Booking booking : bookingListToEvaluate) {
            if (booking.getVacationType() == vacationType.REKREAČNÍ && numberOfRecreationalBookings < numberOfBookings) {
                numberOfRecreationalBookings++;
                recreationalBookings.add(booking);
            }
        }
        printBookings(recreationalBookings);
    }

}
