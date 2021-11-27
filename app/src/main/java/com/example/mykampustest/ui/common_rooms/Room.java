package com.example.mykampustest.ui.common_rooms;

public class Room {
    private String mainText;
    private String hoursText;
    private String descText;
    private int iconId;

    Room(String text, String hoursText, String descText, int iconId){
        this.mainText = text;
        this.descText = descText;
        this.hoursText = hoursText;
        this.iconId = iconId;
    }

    public String getMainText(){
        return mainText;
    }

    public String getHoursText() {
        return hoursText;
    }

    public String getDescText() {
        return descText;
    }

    public int getIconId(){
        return iconId;
    }
}
