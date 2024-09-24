package com.feng.di;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author AsuraTu
 */
public class TestModel {
    // 测试 set 方法注入不同的数据类型
    private int id;

    private String name;

    private Integer age;

    private Double salary;

    private Boolean married;

    private String[] hobbies;

    private Date birthday;

    private List<Integer> scores;

    private Set<String> pets;

    private Map<String, String> clothes;

    // toString 方法
    @Override
    public String toString() {
        return "TestModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", isMarried=" + married +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", birthday=" + birthday +
                ", scores=" + scores +
                ", pets=" + pets +
                ", clothes=" + clothes +
                '}';
    }

    // 打印当前时间 YYYY-MM-dd HH:mm:ss
    public void printTime() {
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println(now);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

    public Set<String> getPets() {
        return pets;
    }

    public void setPets(Set<String> pets) {
        this.pets = pets;
    }

    public Map<String, String> getClothes() {
        return clothes;
    }

    public void setClothes(Map<String, String> clothes) {
        this.clothes = clothes;
    }
}
