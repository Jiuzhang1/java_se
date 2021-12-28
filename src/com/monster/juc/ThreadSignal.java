package com.monster.juc;

/**
 * @author Monster
 * @date 2021年12月27日 21:50
 */
public class ThreadSignal {
    volatile static int  number=0;
    static ThreadSignal threadSignal=new ThreadSignal();
    public static void main(String[] args) {

       new Thread(()->{
           synchronized (threadSignal) {
               try{
                   while(true){
                       if(number!=0){
                           threadSignal.wait();
                       }
                       System.out.println(Thread.currentThread().getName()+":"+number);
                       number++;
                       threadSignal.notify();
                   }
               }catch (Exception e){
                   e.printStackTrace();
               }finally{

               }
           }
       },"A").start();
        new Thread(()->{
            synchronized (threadSignal) {
                try{
                    while(true){
                        if(number==0){
                            threadSignal.wait();
                        }
                        System.out.println(Thread.currentThread().getName()+":"+number);
                        number--;
                        threadSignal.notify();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally{

                }
            }
        },"B").start();
        System.out.println("主线程执行！");
    }
}
