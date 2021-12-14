package com.monster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class demo {
    public static void main(String[] args) {
        Map a=new HashMap();
        ArrayList<Student> s1 = new ArrayList<Student>();
        ArrayList<Student> s2 = new ArrayList<Student>();

        for (int i = 0; i < 10; i++) {
            s1.add(new Student(i*2,i*4));
        }

        for (int i = 0; i < 30; i++) {

            Student student = new Student();

            for (int i1 = 0; i1 < s1.size(); i1++) {
                if(s1.get(i1).id == i){
                    student.setId(s1.get(i1).getId());
                    student.setAge(s1.get(i1).getAge());
                }else {
                    student.setId(i);
                    student.setAge(i);
                }
            }

            s2.add(student);
        }

        System.out.println(11);
    }}

