package com.zhang.lambdademo;

/**
 * jdk1.8之后的lambda表达式
 * 为什么要使用它？
 * 		避免匿名内部内定义过多
 * 		代码简洁，去掉一堆没有意义的代码，只留下核心代码
 * 		实质属于函数式编程的概念
 * 	函数式接口？--
 * 		任何接口只包含唯一一个抽象方法，那么他就是一个函数式接口。
 * 		对于函数式接口可以通过lambda表达式来创建该接口的对象
 */
public class Lambda1 {

    //第二种：静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }
    public static void main(String[] args) {
        //1.创建接口对象
        ILike iLike = new Like();
        iLike.lambda();
        System.out.println("============");
        iLike = new Like2();
        iLike.lambda();
        System.out.println("============");
        //第三种：局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }

        iLike = new Like3();
        iLike.lambda();

        System.out.println("============");
        //第四种：匿名内部类 没有类的名称，必须借助接口或者父类
        iLike = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };
        iLike.lambda();
        System.out.println("============");
        //第五种：用lambda简化
        iLike = ()->{
            System.out.println("I like lambda5");
        };
        iLike.lambda();

    }

}
//接口只包含一个抽象方法
interface ILike{
    void lambda();
}
//第一种：外部实现类
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}
