package edu.cqupt.domain;

/**
 * Created by hg on 2018/7/16.
 */
public class Student {
    private int sid;
    private String name;
    private String password;
    private int age;
    private String className ;

    public Student(String name, String password, int age, String className) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.className = className;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getSid() {
        return sid;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", className='" + className + '\'' +
                '}';
    }
}
