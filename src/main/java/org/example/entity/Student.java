package org.example.entity;

import java.util.UUID;

/**
 * @project testAmaris
 * @autor Oscar Alfredo Chafloque Tampeck
 * @date 19/09/2023
 **/
public class Student {

    private UUID uuid;
    private String name;
    private int rolNumber;

    private String location;

    public Student(UUID uuid, String name, int rolNumber, String location) {
        this.uuid = uuid;
        this.name = name;
        this.rolNumber = rolNumber;
        this.location = location;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRolNumber() {
        return rolNumber;
    }

    public void setRolNumber(int rolNumber) {
        this.rolNumber = rolNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
