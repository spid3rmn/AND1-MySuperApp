package com.example.mykampustest.ui.home;

public class Guide {
    private int iconId;
    private String name;
    private String smallDesc;
    private String guide;

    public Guide(String name, String smallDesc, String guide, int iconId) {
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

    public String getGuide() {
        return guide;
    }
}
