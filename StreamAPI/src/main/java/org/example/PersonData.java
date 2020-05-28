package org.example;

import java.util.ArrayList;
import java.util.List;

public class PersonData {
    public static List<Person> getPerson() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1001,"张三"));
        personList.add(new Person(1002,"李四"));
        personList.add(new Person(1003,"王五"));
        personList.add(new Person(1004,"赵六"));
        personList.add(new Person(1005,"谢七"));
        personList.add(new Person(1006,"秦八"));
        return personList;
    }

}
