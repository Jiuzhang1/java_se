package com.monster.juc;

import java.sql.Connection;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Monster
 * @date 2021年12月29日 22:42
 */
public class ThreadSignal04 {
    public static void main(String[] args) throws InterruptedException {
        Data02 data=new Data02();
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

class Data02 {
    int number = 0;
    Lock lock=new ReentrantLock();
    Condition condition=lock.newCondition();
    public void increment() throws InterruptedException {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + ":" + number);
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {
        lock.lock();
        try{
            while (number != 1) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + ":" + number);
            condition.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }

    }
}