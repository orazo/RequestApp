package com.example.orazoulay.requestapplication;

/**
 * Created by yitzhakbinyamin on 21.12.2017.
 */

public class Marathon extends Product{

    private String LecturerName;
    private int ClassRoom;
    private int Date;
    private int FreeSpots;

    public Marathon(int productID, double price, String courseName, String lecturerName, int classRoom, int date, int freeSpots) {
        super(productID, price, courseName);
        LecturerName = lecturerName;
        ClassRoom = classRoom;
        Date = date;
        FreeSpots = freeSpots;
    }


    //GETTERS AND SETTERS


    public String getLecturerName() {
        return LecturerName;
    }

    public void setLecturerName(String lecturerName) {
        LecturerName = lecturerName;
    }

    
    public int getClassRoom() {
        return ClassRoom;
    }

    public void setClassRoom(int aClass) {
        ClassRoom = aClass;
    }

    public int getDate() {
        return Date;
    }

    public void setDate(int date) {
        Date = date;
    }

    public int getFreeSpots() {
        return FreeSpots;
    }

    public void setFreeSpots(int freeSpots) {
        FreeSpots = freeSpots;
    }
}
