package com.engeto.rooms;

import com.sun.tools.javac.Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private Room room;
    private Guest guest;
     private LocalDate startDate;
    private LocalDate endDate;
    private String vacationType;

    private ArrayList<Guest> guestList = new ArrayList<>();



//region Booking Constructors

    public Booking(Room room, Guest guest, LocalDate startDate, LocalDate endDate, String vacationType) {
        this.room = room;
        this.guest = guest;
        this.startDate = startDate;
        this.endDate = endDate;
        this.vacationType = vacationType;
    }


    public Booking(Guest guest,ArrayList<Guest> guestList,Room room, LocalDate startDate, LocalDate endDate, String vacationType) {
        this.guest = guest;
        this.guestList =guestList;
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

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getVacationType() {
        return vacationType;
    }

    public void setVacationType(String vacationType) {
        this.vacationType = vacationType;
    }

    public ArrayList<Guest> getGuestList() {
        return guestList;
    }

    public void setGuestList(ArrayList<Guest> guestList) {
        this.guestList = guestList;
    }
//endregion


}
