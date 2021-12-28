package com.monster.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Monster
 * @date 2021年12月24日 17:39
 */
public class SaleTicketDemo02 {
    public static void main(String[] args) throws InterruptedException {
        /*创建CountDownLatch实例,计数器的值初始化为3*/
        final CountDownLatch downLatch = new CountDownLatch(3);

        long start=System.currentTimeMillis();
        Ticket02 ticket02=new Ticket02();
        new Thread(()->{ for (int i = 1; i < 333334; i++) { ticket02.subtract();}downLatch.countDown();},"A").start();
        new Thread(()->{ for (int i = 1; i < 333334; i++) { ticket02.subtract();}downLatch.countDown();},"B").start();
        new Thread(()->{ for (int i = 1; i < 333335; i++) { ticket02.subtract();}downLatch.countDown();},"C").start();
        /*主线程调用await()方法,等到其他三个线程执行完后才继续执行*/
        downLatch.await();
        long end=System.currentTimeMillis();
        System.out.println("用时为："+(end-start));
    }
}
class Ticket02{
    int number=1000000;
    Lock lock=new ReentrantLock();
    public void subtract(){
        lock.lock();
        try{
            if(number>0)
                System.out.println(Thread.currentThread().getName()+"卖出"+(number--)+"还剩余"+number+"张票");
        }catch(Exception e){e.printStackTrace();}finally{lock.unlock();}

    }

}