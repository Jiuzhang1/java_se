package com.monster;

public class NanoTime {
    private long start, end;

    public void testFor() {
        start = System.nanoTime();
        for (int i = 1, sum = 0; i <= 100; i++)
            sum += i;
        end = System.nanoTime();
    }

    public long getUsedTime() {
        testFor();
        return end-start;
    }
    public static void main(String args[]){
        NanoTime testFor = new NanoTime();
        System.out.println(testFor.getUsedTime());
    }
}