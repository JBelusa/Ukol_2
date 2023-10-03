package com.engeto.rooms;

import java.time.LocalDate;

public class Booking {
    private Room room;
    private Guest guest;
    private Guest secondguest;
    private LocalDate startDate;
    private LocalDate endDate;
    private String vacationType;


//region Booking Constructors

    public Booking(Room room, Guest guest, LocalDate startDate, LocalDate endDate, String vacationType) {
        this.room = room;
        this.guest = guest;
        this.startDate = startDate;
        this.endDate = endDate;
        this.vacationType = vacationType;
    }

    public Booking(Room room, Guest guest, Guest secondguest, LocalDate startDate, LocalDate endDate, String vacationType) {
        this.room = room;
        this.guest = guest;
        this.secondguest = secondguest;
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

    public Guest getSecondguest() {
        return secondguest;
    }

    public void setSecondguest(Guest secondguest) {
        this.secondguest = secondguest;
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

//endregion


}
