package com.monster.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockQueueTest {
    private BlockingQueue<String> warnQueue = new LinkedBlockingQueue<String>(1000);
    public static void main(String[] args) throws InterruptedException {
        BlockQueueTest a=new BlockQueueTest();
        a.hello();
        while(true){
            TimeUnit.SECONDS.sleep(4);
            if(a.getWarningInfo()!=null) System.out.println(a.getWarningInfo());
        }
    }
    public String getWarningInfo() {
        int size = warnQueue.size();
        System.out.println(size);
        String ret = warnQueue.poll();
        return ret;
    }
    public void hello(){
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                Random r = new Random();
                while (true) {
                    int code = r.nextInt(100);
                    if (code%5==0) {
                        addWarningInfo(String.format("超过5台风机同时出现故障 请及时处理",code ));
                    } else{
                        addWarningInfo(String.format("%d号风机出现故障 请及时处理",code ));
                    }
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
    }
    public void addWarningInfo(String warningInfo) {
        int size = warnQueue.size();
        if (size<1000) {
            warnQueue.add(warningInfo);
            System.out.println("mo");
        }else{
        }
    }
}
