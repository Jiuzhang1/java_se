package com.monster;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.UUID;

public class MapTest {
    public static void main(String[] args) {
        final HashMap<String, String> map = new HashMap<String, String>(2);
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    map.put(UUID.randomUUID().toString(), "");
                }
            }).start();
        }
        Hashtable hashtable = new Hashtable<String,String>();
        hashtable.put("monster","Monster");
        System.out.println("");
    }
}
