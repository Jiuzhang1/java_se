package com.monster;

import java.util.HashMap;
import java.util.Map;

public class DetailDemo1 {
    static String monster = "Monster";
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("hello", "World");
        map.put("monster", "Chenguizhi");
        map.forEach((key, value)->{
            System.out.println( "key=" +key+"\t"+"value="+value);
        });
        DetailDemo1 demo = new DetailDemo1();
        System.out.println(demo.monster);
    }
}