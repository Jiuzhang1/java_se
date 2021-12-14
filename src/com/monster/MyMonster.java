package com.monster;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyMonster {
    public static void main(String[] args) throws ParseException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = sdf.parse("2021-06-01 00:00:00");
        //此处设置为true即可追加
        FileWriter out = new FileWriter("./monster22.txt", true);
        for (int i = 0; i < 30; i++) {
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(startDate.getTime());
            c.add(Calendar.DATE, i);
            Date date = c.getTime();
            System.out.println(date.getTime());
            Map map=new HashMap();
            float min = 5f;
            float max = 10f;
            float MC004 = min + new Random().nextFloat() * (max - min);
            float MC004_MAX = min + new Random().nextFloat() * (max - min);
            float MC004_MIN = min + new Random().nextFloat() * (max - min);
            int MC006 = 0,MC006_first = 0,MC006_last = 0,MC062 = 0,MC062_first = 0,MD001 = 0;
            int week=2;
            SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
            String str11=sdf.format(date);
            Long longDate= date.getTime();
            String str = String.format("WindFarmData1d,day=%s,farm=冷溪山,month=2021-06,project=一期,turbine=10#,type=14632,week=2021年6月第%d周,year=2021,modify=monster MC004=%.2f,MC004_MAX=%.2f,MC004_MIN=%.2f,MC006=%d,MC006_first=%d,MC006_last=%d,MC062=%d,MC062_first=%d,MD001=%d %s", str11,week,MC004,MC004_MAX,MC004_MIN,MC006,MC006_first,MC006_last,MC062,MC062_first,MD001,longDate);
            System.out.println(str);

            //往文件写入
            out.write(str);
            //换行
            out.write("\r\n");
            //刷新IO内存流
            out.flush();
        }
        //关闭
        out.close();
    }
    /**
     * 将long类型转化为Date
     * @param str
     * @return
     * @throws ParseException
     */
    public static Date LongToDare(long str) throws ParseException{
        return new Date(str * 1000);
    }


}
