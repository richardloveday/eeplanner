package com.eeplanner.datastructures;

public enum ContactType {

    staff("staff"),
    familymember("familymember"),
    org("org"),
    coordinator("coordinator"),
    school("school"),
    student("student"),
    leader("leader");

    private String name;

    ContactType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
