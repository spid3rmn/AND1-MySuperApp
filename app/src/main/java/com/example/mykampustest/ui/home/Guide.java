package com.example.mykampustest.ui.home;

public class Guide {
    private int iconId;
    private String name;
    private String smallDesc;
    private int guide;

    public Guide(String name, String smallDesc, int guide, int iconId) {
        this.name = name;
        this.smallDesc = smallDesc;
        this.guide = guide;
        this.iconId = iconId;
    }

    public String getName() {
        return name;
    }

    public String getSmallDesc() {
        return smallDesc;
    }

    public int getIconId(){
        return iconId;
    }

    public int getGuide() {
        return guide;
    }
}
