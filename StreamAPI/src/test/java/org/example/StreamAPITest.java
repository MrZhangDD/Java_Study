package org.example;

import org.junit.Test;

import java.lang.reflect.Array;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPITest {
    /**
     * 创建方式一：通过集合
     */
    @Test
    public void test1(){
        List<Person> list = PersonData.getPerson();
        //返回一个顺序流
        Stream<Person> stream = list.stream();
        //返回一个并行流
        Stream<Person> personStream = list.parallelStream();

    }

    /**
     * 创建Stream二: 通过数组创建
     */
    @Test
    public void test2(){
        int[] a = new int[]{1,2,3,4,5};
        //调用arrays类的static方法
        IntStream stream = Arrays.stream(a);

        Person za = new Person(1, "za");
        Person da = new Person(2, "da");
        Person[] people = {za, da};
        Stream<Person> stream1 = Arrays.stream(people);
    }

    /**
     * Stream创建三：通过stream的of
     */
    @Test
    public void test3(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    /**
     * stream中间操作 1.筛选与切片
     */
    @Test
    public void test4(){
        List<Person> list = PersonData.getPerson();
        //filter（） 过滤操作
        System.out.println("====filter====");
        list.stream().filter(e -> e.getId() > 1002)
                .forEach(System.out::println);

        System.out.println("====limit====");
        //limit() 截断流 -- 使元素不超过给定数量
        list.stream().limit(3).forEach(System.out::println);

        //skip（） 跳过几个元素
        System.out.println("====skip====");
        list.stream().skip(3).forEach(System.out::println);

        //distinct () -- 筛选，通过hashcode()和equals()去重
        System.out.println("====distinct====");
        list.add(new Person(1001,"1001"));
        list.add(new Person(1001,"1001"));
        list.add(new Person(1001,"1001"));
        list.add(new Person(1001,"1001"));

        list.stream().distinct().forEach(System.out::println);
    }

    /**
     * stream中间操作 2.映射
     */
     @Test
    public void test6(){
         //map(Function f) --接受一个函数作为参数，将元素转换成其他形式
         // 或者提取信息，该函数会映射到每个元素上，并将其映射成一个新的元素
         List<String> list = Arrays.asList("aa", "bb", "cc");
         list.stream().map(str -> str.toUpperCase()).forEach(System.out:: println);

         List<Person> person = PersonData.getPerson();
         person.stream()
                 .map(Person::getId)
                 .filter(id -> id>1002)
                 .forEach(System.out::println);
         //flatMap(Function f) - 接受一个函数作为参数,将流中的每个值都换成另一个流，
         //然后把所有流连成一个流.相当于addAll(),打开集合套集合
     }

    /**
     * 排序
     */
    @Test
    public void test8(){
        //sorted -- 自然排序
        List<Integer> list = Arrays.asList(12, 15, 45, 65, 14, 54, 21);
        list.stream().sorted().forEach(System.out::println);

        //sorted(Comparator<? super P_OUT> comparator) 定制排序
        List<Person> personList = PersonData.getPerson();
        personList.stream()
                .sorted((o1,o2) -> Integer.compare(o1.getId(),o2.getId()))
                .forEach(System.out::println);

    }

    /**
     * stream终止操作,1.匹配与查找
     */
    @Test
    public void  test10(){
        List<Person> personList = PersonData.getPerson();
        //allMatch 都通过才为true
        boolean b = personList.stream().allMatch(e -> e.getId() > 1001);
        System.out.println("====allMatch-->"+b);

        boolean b1 = personList.stream().anyMatch(e -> e.getId() > 1001);
        System.out.println("====anyMatch-->"+b1);

        boolean b2 = personList.stream().noneMatch(e -> e.getName().startsWith("张"));
        System.out.println("====noneMatch-->"+b1);

        Optional<Person> first = personList.stream().findFirst();
        System.out.println("====findFirst-->"+first);

        Optional<Person> any = personList.stream().findAny();
        System.out.println("====findAny-->"+any);

        //count个数
        long count = personList.stream().filter(e -> e.getId() > 1002).count();
        System.out.println("====count-->"+count);

        Optional<Integer> max = personList.stream().map(e -> e.getId()).max(Double::compare);
        System.out.println("====max-->"+max);

        Optional<Person> min = personList.stream().min((o1, o2) -> Double.compare(o1.getId(), o2.getId()));
        System.out.println("====min-->"+min);

        personList.stream().forEach(System.out::println);

    }

    /**
     * 2.规约
     */
    @Test
    public void test11(){
        //reduce()--可以流中元素反复结合起来，得到一个值，返回Optional<Person>
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //reduce(T identity--初始值, BinaryOperator<T> accumulator);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        //Optional<T> reduce(BinaryOperator<T> accumulator);
        List<Person> personList = PersonData.getPerson();
        Stream<Integer> integerStream = personList.stream().map(Person::getId);
        System.out.println(integerStream.reduce(Integer::sum));

    }

    //3.收集

    @Test
    public void test12(){
        List<Person> person = PersonData.getPerson();
        List<Person> collect = person.stream().filter(e -> e.getId() > 1002).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
