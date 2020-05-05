package com.zhang.lambdademo;


public class Lambda2 {

    public static void main(String[] args) {
        ILove love = new Love();
        love.love(2);

        //1.lambda表示
        love = (int a)-> {
            System.out.println("I LOVE YOU -->"+ a);
        };
        love.love(520);

        //2.简化参数类型
        love = (a) ->{
            System.out.println("I LOVE YOU -->"+ a);
        };
        love.love(521);
        //3.简化括号
        love = a ->{
            System.out.println("I LOVE YOU -->"+ a);
        };
        /* 多个参数必须加个括号
        love = (a,b) ->{
            System.out.println("I LOVE YOU -->"+ a);
        };
         */

        love.love(522);
        //3.简化花括号
        love = a ->
            System.out.println("I LOVE YOU -->"+ a);
        love.love(523);

        //总结：lambda表达式只有一行代码的情况下才能简化成一行，
        // 如果有多行，那么就用代码块包裹
        //前提是函数式接口
    }
}

interface ILove{
    void love(int a);
}
class Love implements ILove{
    @Override
    public void love(int a) {
        System.out.println("I LOVE YOU -->"+ a);
    }
}