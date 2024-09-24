package com.feng.di;

/**
 * @author AsuraTu
 */
public class TestModel2 {
    // 使用构造方法注入

    private String name;
    private int id;

    public TestModel2() {
    }

    public TestModel2(int id) {
        this.id = id;
    }

    public TestModel2(String name) {
        this.name = name;
    }

    public TestModel2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
