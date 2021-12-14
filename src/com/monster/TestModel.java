package com.monster;

public class TestModel {
    private String name;
    private String value;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public TestModel(String name, String value) {
        this.name = name;
        this.value = value;
    }
    @Override
    public String toString() {
        return "TestModel [name=" + name + ", value=" + value + "]";
    }



}


