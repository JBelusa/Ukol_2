package com.engeto.rooms;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Guest {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

//region Guest Constructors


    public Guest(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    //endregion
//region Guest Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setGuestName(String guestName) {
        this.firstName = guestName;
    }

    public LocalDate getBirthDate() {

        return birthDate;
    }

    //Úprava formátu datumu narození
    public String formattedDate() {
        return birthDate.format(DateTimeFormatter.ofPattern("d.M.uuuu"));
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return getFirstName() + " " +getLastName() +" (" + formattedDate() + ")"
                ;
    }

//endregion


}
