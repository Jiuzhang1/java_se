package com.monster;

import java.util.Random;
import java.util.stream.Stream;

public class Randoms {

    public static void main(String[] args) {
        new Random(50)	// 创建 Random 对象，并给一个种子
                .ints(5, 20)	// 产生一个限定了边界的随机整数流
                .distinct()	// 使流中的整数不重复
                .limit(7)	// 取前7个元素
                .sorted()	// 排序
                .forEach(System.out::println);	// 根据传递给它的函数对流中每个对象执行操作
        /*Stream.of(new Double(1), new Double(2), new Double(3)).forEach(System.out::println);
        Stream.of("a", "b", "c", "d", "e", "f").forEach(System.out::print);
        Stream.of(3.14159, 2.718, 1.618).forEach(System.out::println);
        Stream.generate(Math::random).limit(10).forEach(System.out::print);*/
        Stream.of("a b c d e".split(" ")).map(w -> w + " ").peek(System.out::print);
        Stream.of(1, 2, 3).flatMap(i -> Stream.of("hello" + i)).forEach(System.out::println);
    }
}
