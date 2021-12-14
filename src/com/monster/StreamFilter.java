package com.monster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        list.stream()
                .filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 3)
                .forEach(System.out::println);



        List<Integer> listInteger = new ArrayList<>();
        listInteger.add(1);
        listInteger.add(3);
        listInteger.add(5);
        listInteger.add(1);
        listInteger.add(0);
        System.out.println("原始输出listInteger:***************************************************");
        System.out.println(listInteger);
        System.out.println("lambda正序输出listInteger:***************************************************");
        Collections.sort(listInteger);
        listInteger.forEach(s-> System.out.println(s));
        System.out.println("lambda逆序输出listInteger:***************************************************");
        Collections.reverse(listInteger);
        listInteger.forEach(s-> System.out.println(s));
        System.out.println("java的Stream流正序序输出listInteger:***************************************************");
        List<Integer> list1 = listInteger.stream().sorted().collect(Collectors.toList());
        System.out.println(list1);
        System.out.println("java的Stream流逆序序输出listInteger:***************************************************");
        List<Integer> list2= listInteger.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(list2);


    }
}
