package com.monster;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Test {


    public static void main(String args[]) throws ParseException {
        int a=59;
        List<String> list = new ArrayList<>();
        for (int i=0;i<30;i++){
            String newString = String.format("%02d", (a+30+i+1)%60);
            list.add(newString);
        }
        Student student = new Student();
        student.setSalary(23.0);
        student.setWeight(27.53434);
        System.out.println(student.getSalary());
        System.out.println(student.getWeight());
        System.out.println("##############################");
        double dou = 0.0;
        String douStr = String.format("%.2f", 0.0);
        System.out.println(douStr);
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(0.0));
        System.out.println("*************");
        //当前时间Date
        Date now = new Date();
        System.out.println(now);
//Wed Jan 31 23:32:03 GMT+08:00 2018

//例如我的环境时区为：(UTC+08:00)北京，重庆，香港特别行政区，乌鲁木齐（+0800）
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'");
        System.out.println(sdf.getTimeZone());
        System.out.println(sdf.format(now));
//sun.util.calendar.ZoneInfo[id="GMT+08:00",offset=28800000,dstSavings=0,useDaylight=false,transitiOns=0,lastRule=null]
//2018-01-31T23:32:03.469+0800






        List<String> dates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        String dateString = "2018-02-23";
        Date date= new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        calendar.setTime(date);
        /* 核心代码 */
        for (int i = 1; i <= 30; i++) {
            calendar.add(Calendar.MINUTE, -1);// 5分钟之前的时间
            Date beforeD = calendar.getTime();
            String before5 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm':00+08:00'").format(beforeD);
            dates.add(before5);
        }
        System.out.println(dates);


    }

}
