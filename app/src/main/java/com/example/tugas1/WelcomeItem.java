package com.example.tugas1;

public class WelcomeItem {
    String welcome_text,sub_welcome;
    int img_slide,background;

    public WelcomeItem(String welcome_text, String sub_welcome, int img_slide, int background) {
        this.welcome_text = welcome_text;
        this.sub_welcome = sub_welcome;
        this.img_slide = img_slide;
        this.background = background;
    }

    public String getWelcome_text() {
        return welcome_text;
    }

    public void setWelcome_text(String welcome_text) {
        this.welcome_text = welcome_text;
    }

    public String getSub_welcome() {
        return sub_welcome;
    }

    public void setSub_welcome(String sub_welcome) {
        this.sub_welcome = sub_welcome;
    }

    public int getImg_slide() {
        return img_slide;
    }

    public void setImg_slide(int img_slide) {
        this.img_slide = img_slide;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }
}
