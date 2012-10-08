package com.eeplanner.datastructures;

public enum NoteType  {
    camp("camp"),
    staff("staff"),
    profile("profile"),
    contact("contact"),
    travelInfo("travelInfo"),
    diet("diet"),
    medical("medical");

    private String name;

    NoteType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}