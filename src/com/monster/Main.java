package com.monster;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException, ParseException {
        String oldDateStr = "2021-08-30T20:30:00+08:00";
        //此格式只有  jdk 1.7才支持  yyyy-MM-dd'T'HH:mm:ss.SSSXXX

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");  //yyyy-MM-dd'T'HH:mm:ss.SSSZ
        Date date = df.parse(oldDateStr);
        System.out.println(date);



        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String df3=df2.format(date);
        System.out.println(df3);

        SimpleDateFormat sf = new SimpleDateFormat(df3);
        System.out.println(sf.parse(df3).getTime());
        Number  a = df2.parse(String.valueOf(df3)).getTime();
        System.out.println(a);



        //将Date转换为String
        Date currentTime = new Date();
        //2021-08-03T11:13:00.000Z
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'z'");
        String dateString = formatter.format(currentTime);
        System.out.println(dateString);

        long startTime = System.currentTimeMillis();
        // 程序执行
        for (Long i = 0L; i < 10000000L; i++) {

        }
        // 结束
        long endTime = System.currentTimeMillis();
        System.out.println("程序用时：" + (endTime - startTime)/1000+"s");

    }

}
