package com.eeplanner.datastructures;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 11-Dec-2009
 * Time: 12:51:22
 * To change this template use File | Settings | File Templates.
 */
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