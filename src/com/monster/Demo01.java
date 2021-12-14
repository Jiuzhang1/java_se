package com.monster;

import java.util.HashMap;

public class Demo01 {
    public static void main(String[] args) {
        String subFile="1223232.jpg";
        if(subFile.endsWith(".jpg")&&subFile.startsWith("1224")){
            System.out.println("文件格式正确");
        }else{System.out.println("文件格式不正确");}


    }

}
