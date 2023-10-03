package com.engeto.rooms;

import java.time.LocalDate;

public class Guest {
    private String guestName;
    private LocalDate birthDate;

//region Guest Constructors

    public Guest(String guestName, LocalDate birthDate) {
        this.guestName = guestName;
        this.birthDate = birthDate;
    }

//endregion
//region Guest Getters and Setters
    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }



//endregion


}
