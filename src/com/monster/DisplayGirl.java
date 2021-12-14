package com.monster;

public class DisplayGirl {
    public static void main(String[] args) {
        LittleGirl myGirl = new LittleGirl("Lingzi",18,160,99);
        LittleGirl heartGirl = new LittleGirl("MonsterGril",23,162,101);
        System.out.println("热烈欢迎我们的小林子！");
        int cx = 0, cy = 0; // 问y 、 x 总共循环了多少次
        float dx = 0.05f, dy = 0.1f;
        int stars=0;//计数器
        for (float y = (float)1.5; y > -1.5; y -= dy, cy++){
            cx = 0;
            for (float x = (float) -1.5; x < 1.5; x += dx, cx++){
                float a = x * x + y * y - 1;
                if ((a * a * a - x * x * y * y * y) <= 0.0){
                    System.out.print("*");// 心形区域内打印*
                    stars++;
                } else{
                    System.out.print(" "); // 心形区域外打印空格
                }
            }
            System.out.println("");    // 本行结束，换行准备下一行的输出
        }

        //System.out.printf("cx=%d, cy=%d%n", cx, cy);
        //System.out.printf("count=%d", stars);
        String s = String.format("Hello,大家好,我是：%s, 我今年%d,身高为%d,体重为%.2f", myGirl.getName(), myGirl.getAge(),myGirl.getHeight(),myGirl.getWeight());
        System.out.println(s+"\n");
        System.out.println("接下来请允许我介绍下我的女神MonsterGirl!");
        //分三个大部分 上中下
        for(int i=0,k=0; i<14;i++){//打印行
            //上部分 上分为 四个部分
            if(i<3){
                for(int j=0;j<5-2*i;j++){//1、空心
                    System.out.print(" ");
                }
                if(i==2){//2、*
                    for(int j=0;j<6+4*i-1;j++){
                        System.out.print("*");
                    }
                    for(int j=0;j<7-4*i+2;j++){//3、空心
                        System.out.print(" ");
                    }
                    for(int j=0;j<6+4*i-1;j++){//4、*
                        System.out.print("*");
                    }
                }else{
                    for(int j=0;j<6+4*i;j++){//2、*
                        System.out.print("*");
                    }
                    for(int j=0;j<7-4*i;j++){//3、空心
                        System.out.print(" ");
                    }
                    for(int j=0;j<6+4*i;j++){//4、*
                        System.out.print("*");
                    }
                }
            }else if(i<6){//中间
                for(int j=0;j<29;j++){
                    System.out.print("*");
                }
            }else{//下部分 6
                if(i==13){
                    for(int j=0;j<2*(i-6);j++){//打印空格
                        System.out.print(" ");
                    }
                    System.out.print("*");
                }else{
                    for(int j=0;j<2*(i-6)+1;j++){//打印空格
                        System.out.print(" ");
                    }
                    for(int j=1;j<28-4*k;j++){
                        System.out.print("*");
                    }
                    k++;
                }
            }
            System.out.println();//换行
        }
        String heart_girl = String.format("Hello,大家好,今天能见到大家我很开心，我是陈墨的女朋友，我叫%s, 我今年%d,身高为%d,体重为%.2f", heartGirl.getName(), heartGirl.getAge(),heartGirl.getHeight(),heartGirl.getWeight());
        System.out.println(heart_girl);
    }

}
