package com.monster.juc;

/**
 * @author Monster
 * @date 2021年12月29日 22:42
 */
public class ThreadSignal03 {
    public static void main(String[] args) throws InterruptedException {
        Data data=new Data();
        new Thread(()-> {
            try {
                while (true) data.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        new Thread(()-> {
            try {
                while (true) data.decrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}
class Data {
    int number = 0;

    public synchronized void increment() throws InterruptedException {
        if (number != 0) {
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + ":" + number);
        this.notify();
    }

    public synchronized void decrement() throws InterruptedException {
        if (number != 1) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + ":" + number);
        this.notify();
    }
}