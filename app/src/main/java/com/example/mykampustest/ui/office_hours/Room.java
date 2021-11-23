package com.example.mykampustest.ui.office_hours;

public class Room {
    private String mainText;
    private int iconId;

    Room(String text, int iconId){
        this.mainText = text;
        this.iconId = iconId;
    }

    public String getMainText(){
        return mainText;
    }

    public int getIconId(){
        return iconId;
    }
}
