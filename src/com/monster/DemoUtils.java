package com.monster;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DemoUtils {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person());
        //personList.add(null);
        personList.add(new Person("小明",10));
        personList.add(new Person("小红",12));
        Optional.ofNullable(personList).orElseGet(() -> {
            System.out.println("personList为null！");
            return new ArrayList<>();
        }).stream().filter(Objects::nonNull).forEach(person -> {
            System.out.println(person.getName());
            System.out.println(person.getAge());
        });
    }

    static class Person {
        private String name;
        private int age;

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
    }
}
