package com.example.demo.com.zc.java8;

import com.example.demo.com.zc.service.StudentService;
import com.example.demo.com.zc.vo.Person;
import com.rabbitmq.tools.json.JSONUtil;

import javax.transaction.Transaction;
import java.io.UnsupportedEncodingException;
import java.time.*;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by zhangchi5 on 2018/12/25.
 */
public class TestExample {

    public static void main(String[] args) throws Exception {
        List<String> names = Arrays.asList("张驰","黄婷","张雨","sb","zhouyuan","blue","haha");
        /*List<String> filter = names.stream().filter(p -> p.equals("sb")).collect(Collectors.toList());
        System.out.print("filter: ");
        filter.forEach(System.out::println);
        Long count = names.stream().count();
        System.out.println("count: " + count);
        List<String> defaultSorted = names.stream().filter(p -> !p.equals("张驰")).sorted().collect(Collectors.toList());
        System.out.println("排序：" + defaultSorted);
        List<String> limit = names.stream().limit(2).collect(Collectors.toList());
        System.out.println("limit: " + limit);
        List<String> parallel = names.parallelStream().map(p -> p.concat("124")).collect(Collectors.toList());
        System.out.println("并行流：" + parallel);
        IntStream.range(1,3).forEach(System.out::println);
        IntStream stream = IntStream.rangeClosed(6,10);
        stream.forEach(System.out::println);
        //Optional
        String a = "123";
        String b = null;
        Optional.ofNullable(a).ifPresent(o -> System.out.println("a: " + a));
        Optional.ofNullable(b).ifPresent(o -> System.out.println("b: " + b));*/
        /*Optional<String>  first = names.stream().findFirst();
        System.out.println("first: " + first.get());
        int length = getLength(null);
        System.out.println("length: " + length);
        String maxStr1 = names.stream().reduce("",String::concat);
        String maxStr2 = names.stream().reduce(String::concat).get();
        System.out.println("maxStr1: " + maxStr1);
        System.out.println("maxStr2: " + maxStr2);
        List<Person> personList = new ArrayList<>();
        for (int i = 1; i <= 100;i++) {
            personList.add(new Person(i));
        }

        Map<Integer,List<Person>> map = java.util.stream.Stream.generate(new StudentService())
                .limit(10)
                .collect(Collectors.groupingBy(Person::getAge));
        Map<Boolean,List<Person>> booleanListMap = java.util.stream.Stream.generate(new StudentService())
                .limit(10)
                .collect(Collectors.partitioningBy(p -> p.getAge() < 2));
        for (Map.Entry<Integer,List<Person>> o : map.entrySet()) {
            System.out.println("age: " + o.getKey() + ": size：" + o.getValue().size());
        }
        *//*for (Map.Entry<Boolean,List<Person>> o : booleanListMap.entrySet()) {
            System.out.println("<2: " + o.getValue(true).size());
        }*//*
        Person pes = new Person();
        pes.setName("101.0");
        pes.setAge(Optional.ofNullable(pes.getName()).map(p -> Double.valueOf(p).intValue()).orElse(null));
        System.out.println(pes.getAge());*/
        //不使用时区
        /*LocalDate localDate = LocalDate.now();
        System.out.println("current： " + localDate);
        LocalTime localTime = LocalTime.now();
        System.out.println("localTime:" + localTime);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime:" + localDateTime);
        LocalDateTime hebing = localDate.atTime(localTime);
        System.out.println("hebing: " + hebing);
        Month month = localDate.getMonth();
        System.out.println("month:" + month + "value:" + month.getValue());
        int day = localDate.getDayOfMonth();
        System.out.println("day: " + day);
        //使用时区
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime: " + zonedDateTime);
        ZoneId zoneId = ZoneId.of("Europe/Paris");
        LocalDateTime parisLocalDateTime = zonedDateTime.withZoneSameInstant(zoneId).toLocalDateTime();
        System.out.println("当前巴黎时间是：" + parisLocalDateTime);*/

        String source = "123456789SDFGHJKMNBFDRthjkmfdrtyjnbtrtduikftyhj12345678!@#$%^&*&^%$#@#$%";
        String base64 = Base64.getEncoder().encodeToString(source.getBytes());
        System.out.println("base64:" + base64);
        String baseSource = new String(Base64.getDecoder().decode(base64));
        System.out.println("baseSource:" + baseSource);
        String urlBase64 = Base64.getUrlEncoder().encodeToString(source.getBytes());
        System.out.println("urlBase64: " + urlBase64);
        String urlSource = new String(Base64.getUrlDecoder().decode(urlBase64));
        System.out.println("urlSource:" + urlSource);
        String mimeBase64 = Base64.getMimeEncoder().encodeToString(source.getBytes());
        System.out.println("mimeBase64:" + mimeBase64);
        String mimeSource = new String(Base64.getMimeDecoder().decode(mimeBase64.getBytes()));
        System.out.println("mimeSource:" + mimeSource);



    }

    /**
     * 获取长度
     * @param msg
     * @return
     */
    public static int getLength (String msg) {
        return Optional.ofNullable(msg).map(String::length).orElse(-1);
    }
}
