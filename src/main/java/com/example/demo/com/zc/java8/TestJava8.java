package com.example.demo.com.zc.java8;

import com.example.demo.com.zc.vo.Person;
import com.example.demo.com.zc.vo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 测试Java8新特性
 */
@Slf4j
public class TestJava8 {

    public static void main(String[] args) {
        TestJava8 testJava8 = new TestJava8();
        //排序测试
        /*List<String> list7 = new ArrayList<>();
        list7.add("张驰1");
        list7.add("黄婷");
        list7.add("asdf");
        System.out.println("java 7 sort");
        testJava8.sortByName7(list7);
        System.out.println(list7);
        List<String> list8 = new ArrayList<>();
        list8.add("张驰1");
        list8.add("黄婷");
        list8.add("asdf");
        System.out.println("java 8 sort");
        testJava8.sortByName8(list8);
        System.out.println(list8);*/

        /*// 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + testJava8.operate(10, 5, addition));
        System.out.println("10 - 5 = " + testJava8.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + testJava8.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + testJava8.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");*/

        testJava8.noResult(() -> System.out.println("test 无参情况"));
        testJava8.paramNoResult((a,b) -> System.out.println("有参数无返回值：" + a + b));
        testJava8.result((a,b) -> {
            int c = a + b;
            System.out.println("有参数有返回值：" + c);
            return c;
        });


    }

    private void noResult (FunctionVoid function) {
        function.test();
    }

    private void paramNoResult (ParamFunctionVoid paramFunctionVoid) {
        paramFunctionVoid.test(0,0);
    }

    private int result (Function function) {
        return function.count(0,0);
    }

    /*interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }*/

    /**
     * java 7 sort
     * @param list
     */
    private void sortByName7 (List<String> list) {
        if (!StringUtils.isEmpty(list)) {
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
        }
    }

    /**
     * java 8 sort
     * @param list
     */
    private void sortByName8 (List<String> list) {
        if (!StringUtils.isEmpty(list)) {
            Collections.sort(list, (s1,s2) -> s1.compareTo(s2));
        }
    }


}
