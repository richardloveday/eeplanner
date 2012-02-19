package com.eeplanner.datastructures;


/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 08-Dec-2009
 * Time: 15:26:03
 * To change this template use File | Settings | File Templates.
 */
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
