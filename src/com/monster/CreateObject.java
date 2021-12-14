package com.monster;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CreateObject{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        Person person= Person.class.newInstance();
        System.out.println(person.getName());
        System.out.println(person.getAge());
        // 包括public的和非public的，当然也包括private的
        Constructor<?>[] declaredConstructors = Person.class.getDeclaredConstructors();
        // 只返回public的~~~~~~(返回结果是上面的子集)
        Constructor<?>[] constructors = Person.class.getConstructors();


        Constructor<?> noArgsConstructor = declaredConstructors[0];
        Constructor<?> haveArgsConstructor = declaredConstructors[1];

        noArgsConstructor.setAccessible(true); // 非public的构造必须设置true才能用于创建实例
        Object person1 = noArgsConstructor.newInstance();
        Object person2 = declaredConstructors[1].newInstance("fsx", 18);

        System.out.println(person1);
        System.out.println(person2);
    }
}
