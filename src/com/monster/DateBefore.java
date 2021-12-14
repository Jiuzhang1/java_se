package com.monster;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DateBefore {
    interface eat
    {
        void eatFood();
    }

    public static void main(String[] args) {
        Date date=new Date();
        System.out.println(getDateBefore(date,5));
        new Thread(() -> System.out.println("Hello")).start();
        ArrayList<String> list = new ArrayList<>();
        list.add("AAAAA");
        list.add("BBBBB");
        list.add("CCCCC");
        list.add("DDDDD");
//形参的类型是确定的，可省略；只有一个形参，()可以省略；
        list.forEach(t -> {System.out.print(t + "\t");});
//或者更简洁的方法引用：list.forEach(System.out::println);
        //打印结果：AAAAA	BBBBB	CCCCC	DDDDD
    }
    /**
     * 得到几天前的时间
     * @param d
     * @param day
     * @return
     */
    public static Date getDateBefore(Date d, int day){
        Calendar now =Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE,now.get(Calendar.DATE)-day);
        return now.getTime();
    }
}
