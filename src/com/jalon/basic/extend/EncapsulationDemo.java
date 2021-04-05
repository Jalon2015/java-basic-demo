package com.jalon.basic.extend;

/**
 * 封装的好处
 */
public class EncapsulationDemo {
    public static void main(String[] args) {

    }
}
class Person{
    private int age;

    private String name;
    private String firstName;
    private String lastName;


    // 方法名不用变，只是方法内容作了修改
    public String getName() {
        return firstName + lastName;
    }

    public void setName(String name) {
        System.out.println("名字即将被修改");
        System.out.println("旧名字：" + this.name);
        System.out.println("新名字：" + name);
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        if(age>1000 || age<0){
            throw new Exception("年龄不符合规范，0~1000");
        }
        this.age = age;
    }
}
