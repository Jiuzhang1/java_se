package com.monster;

import java.math.BigDecimal;

public class Student {

    Integer id;
    Integer age;
    Double salary;
    Double weight;
    public Student(Integer id,Integer age){
        this.id = id;
        this.age=age;
    }
    public Student(){

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return doubleValue(2,salary);
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getWeight() {
        return doubleValue(1,weight);
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double doubleValue(int dex ,Double value) {
        BigDecimal temp  =   new   BigDecimal(value);
        value   =   temp.setScale(dex,   BigDecimal.ROUND_HALF_UP).doubleValue();
        return value;
    }
}
