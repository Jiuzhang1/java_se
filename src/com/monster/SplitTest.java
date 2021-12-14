package com.monster;

public class SplitTest {
    public static void main(String[] args) {
        String str="R011&SE8720";
        String[] deviceIds = str.split("-");
        String dev=deviceIds[0];
        String device = dev.split("&")[0];
        System.out.println(dev);
        System.out.println(device);
        String deviceType = dev.split("&")[1];
        System.out.println(deviceType);
    }
}
