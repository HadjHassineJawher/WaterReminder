package com.water.reminder.Class;

import android.graphics.drawable.Drawable;

public class status {
    private String day;
    private String percentege;
    private String image;
    private String icon;

    public status() {
    }

    public status(String day, String percentege, String image, String icon) {
        this.day = day;
        this.percentege = percentege;
        this.image = image;
        this.icon = icon;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getPercentege() {
        return percentege;
    }

    public void setPercentege(String percentege) {
        this.percentege = percentege;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "status{" +
                "day='" + day + '\'' +
                ", percentege='" + percentege + '\'' +
                ", image='" + image + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
