package com.engeto.rooms;

import java.util.ArrayList;

public class Room {
    private int roomNumber;
    private int numberOfBeds;
    private boolean hasBalcony;
    private boolean hasSeaView;
    private int pricePerNight;


//region Rooms Constructors

    public Room(int roomNumber, int numberOfBeds, boolean hasBalcony, boolean hasSeaView, int pricePerNight) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.hasBalcony = hasBalcony;
        this.hasSeaView = hasSeaView;
        this.pricePerNight = pricePerNight;
    }
//endregion

//region Room Getters and Setters


    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    //Přepsání TRUE/FALSE na Ano/Ne pro balkón
    public String hasBalcony() {
        if (hasBalcony) {
            return "Ano";
        }
        return "Ne";
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    //Přepsání TRUE/FALSE na Ano/Ne pro výhled na moře
    public String hasSeaView() {
        return hasSeaView ? "Ano" : "Ne";
    }

    public void setHasSeaView(boolean hasSeaView) {
        this.hasSeaView = hasSeaView;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }


//endregion


    @Override
    public String toString() {
        return
                "Číslo pokoje:" + roomNumber + "," + " Počet postelí " + numberOfBeds + "," + " Má balkón? " + hasBalcony() + "," + " Má výhled na moře ? " + hasSeaView() + "," + " Cena za noc:" + pricePerNight + " Kč";
    }

}
