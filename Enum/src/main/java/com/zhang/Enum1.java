package com.zhang;


public enum Enum1 {
    PERSON1("张三","河南省"),
    PERSON2("王五","北京市"),
    PERSON3("赵四","云南省");

    //私有构造方法 -- enum的构造方法只能被声明为private权限或不声明权限
    Enum1(String name,String addr) {
        this.name = name;
        this.addr = addr;
    }
    private String name;
    private String addr;

    //普通方法
    public String getName() {
        return name;
    }

    public String getAddr() {
        return addr;
    }

    //抽象方法
    //public abstract String getPerson();
    //静态方法
    public static void main(String[] args) {

    }

}
