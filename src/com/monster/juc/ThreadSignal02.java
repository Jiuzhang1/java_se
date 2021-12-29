package com.monster.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Monster
 * @date 2021年12月28日 23:10
 */
public class ThreadSignal02 {
    static int number=0;

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(()->{
            try{
                while(true){
                    lock.lock();
                    if (number != 0){
                        condition.await();
                    }
                    number++;
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    condition.signalAll();
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        },"A").start();
        new Thread(()->{
            try{
                while (true){
                    lock.lock();
                    if (number != 1){
                        condition.await();
                    }
                    number--;
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    condition.signalAll();
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        },"B").start();
    }
}
