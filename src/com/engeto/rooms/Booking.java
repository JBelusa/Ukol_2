package com.engeto.rooms;

import com.sun.tools.javac.Main;

import java.awt.print.Book;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Booking {
    private Room room;
    private Guest guest;
    private LocalDate startDate;
    private LocalDate endDate;
    private vacationType vacationType;

    private ArrayList<Guest> guestList = new ArrayList<>();


//region Booking Constructors

    public Booking(Room room, Guest guest, LocalDate startDate, LocalDate endDate, vacationType vacationType) {
        this.room = room;
        this.guest = guest;
        this.startDate = startDate;
        this.endDate = endDate;
        this.vacationType = vacationType;
    }


    public Booking(Room room, Guest guest, ArrayList<Guest> guestList, LocalDate startDate, LocalDate endDate, vacationType vacationType) {
        this.guest = guest;
        this.guestList = guestList;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.vacationType = vacationType;
    }


    //endregion

//region Booking Getters and Setters

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }


    public LocalDate getStartDate() {
        return startDate;
    }


    //Úprava formátu datumu začátku rezervace
    public String formattedStartDate() {
        return startDate.format(DateTimeFormatter.ofPattern("d.M.uuuu"));
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    //Úprava formátu datumu konce rezervace
    public String formattedEndDate() {
        return endDate.format(DateTimeFormatter.ofPattern("d.M.uuuu"));
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public vacationType getVacationType() {
        return vacationType;
    }

    public void setVacationType(vacationType vacationType) {
        this.vacationType = vacationType;
    }

    public ArrayList<Guest> getGuestList() {
        return guestList;
    }

    public void setGuestList(ArrayList<Guest> guestList) {
        this.guestList = guestList;
    }

    //Délka pobytu
    public long getBookingLength() {

        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    //Cena pobytu
    public long getPrice(){
        return getBookingLength()*getRoom().getPricePerNight();
    }

    //Celkový počet hostů
    public int getNumberOfGuests() {
        int numberOfGuests = 0;
        if (guest != null) {
            numberOfGuests++;
        }
        if (guestList != null) {
            numberOfGuests += guestList.size();

        }
        return numberOfGuests;
    }


//endregion


    @Override
    public String toString() {
        return formattedStartDate() + " až "
                + formattedEndDate() + " " + getGuest().getFirstName()
                + " " + getGuest().getLastName()
                + "[" + (1 + getGuestList().size()) + ", " + getRoom().hasSeaView() + "]"
                + " za " + getPrice() + " Kč";
    }
}
