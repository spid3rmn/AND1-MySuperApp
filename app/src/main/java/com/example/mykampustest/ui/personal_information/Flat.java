package com.example.mykampustest.ui.personal_information;

public class Flat {
    private String mainText;
    private int iconId;

    Flat(String text, int iconId){
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
