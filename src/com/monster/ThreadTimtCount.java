package com.monster;

import java.util.concurrent.CountDownLatch;

public class ThreadTimtCount implements Runnable {
    static long startTime = System.currentTimeMillis();// 开始时间
    final static CountDownLatch countDownLatch = new CountDownLatch(500);
    public static void main(String[] args) throws InterruptedException {
        ThreadTimtCount count = new ThreadTimtCount();
        for (int i = 1; i <= 500; i++) {
            Thread thread = new Thread(count);
            thread.start();                //countDownLatch.await(); 错误的写法，这会导致thread执行一遍之后，线程被挂起，然后第二次for循环无法执行了（程序挂起等待），这样造成程序假死（卡死）
        }
        countDownLatch.await();  //一定要等到countDown()方法执行完毕后才使用
        System.out.println("执行总时间:"+(System.currentTimeMillis()-startTime));
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println("currThread " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            countDownLatch.countDown();
        }
    }
}
