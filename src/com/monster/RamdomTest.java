package com.monster;

import java.util.Random;

public class RamdomTest {
    public static void main(String[] args) {
        while (true){
            Random ramdom=new Random();
            int code = ramdom.nextInt(100);
            System.out.println(code);
        }
    }
}
