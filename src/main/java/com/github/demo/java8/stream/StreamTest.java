package com.github.demo.java8.stream;

import com.github.demo.domain.Bar;
import com.github.demo.domain.Foo;
import com.github.demo.domain.User;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author 小眼睛带鱼
 * @Description
 * @Date 2019/7/26
 **/
public class StreamTest {

    public static void main(String[] args) {
        //structure();
        //basic();
        //streamToOther();
        /**
         * @author dongganen
         * @date 2019/7/29
         * @desc:
         *  可以通过常规对象流（regular object stream）的mapToInt(), mapToLong()，mapToDouble()，
         *  基本类型对象流（primitive streams）中的mapToObj()等方法完成常规对象流和基本类型流之间的相互转换
         */
        //map();
        //filter();
        //findFirst();
        //reduce();
        //limit();
        //skip();
        //skip2();
        //sorted();
        //minMaxDistinct();
        //match();
        //generate();
        //groupingBy();
        //partitioningBy();
        //test();
        //test1();
        //test2();
        //test3();
        //test4();
        //test5();
        //test6();
        //test7();
        test8();
    }

    private static void test8() {
        List<User> users = new ArrayList();
        users.add(new User(1, "name" + 1, 10));
        users.add(new User(2, "name" + 2, 21));
        users.add(new User(3, "name" + 3, 34));
        users.add(new User(4, "name" + 4, 6));
        users.add(new User(5, "name" + 5, 55));
        users.add(new User(6, "name" + 6, 55));

        users.stream()
                .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2)
                .ifPresent(System.out::println);
    }

    private static void test7() {
        IntStream.range(1, 4)
                .mapToObj(i -> new Foo("Foo" + i))
                .peek(f -> IntStream.range(1, 4)
                        .mapToObj(i -> new Bar("Bar" + i + " <- " + f.getName()))
                        .forEach(f.bars::add))
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.getName()));
    }

    private static void test6() {
        List<Foo> foos = new ArrayList<>();

        // create foos
        IntStream
                .range(1, 4)
                .forEach(i -> foos.add(new Foo("Foo" + i)));

        foos.forEach(f ->
                IntStream
                        .range(1, 4)
                        .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.getName()))));

        foos.stream()
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.getName()));
    }

    private static void test5() {
        List<User> users = new ArrayList();
        users.add(new User(1, "name" + 1, 10));
        users.add(new User(2, "name" + 2, 21));
        users.add(new User(3, "name" + 3, 34));
        users.add(new User(4, "name" + 4, 6));
        users.add(new User(5, "name" + 5, 55));
        users.add(new User(6, "name" + 6, 55));

        Collector<User, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),          // supplier
                        (j, p) -> j.add(p.getName().toUpperCase()),  // accumulator
                        (j1, j2) -> j1.merge(j2),               // combiner
                        StringJoiner::toString);                // finisher

        String names = users
                .stream()
                .collect(personNameCollector);

        System.out.println(names);  // MAX | PETER | PAMELA | DAVID
    }

    private static void test4() {
        //Stream转Map
        List<User> users = new ArrayList();
        users.add(new User(1, "name" + 1, 10));
        users.add(new User(2, "name" + 2, 21));
        users.add(new User(3, "name" + 3, 34));
        users.add(new User(4, "name" + 4, 6));
        users.add(new User(5, "name" + 5, 55));
        users.add(new User(6, "name" + 6, 55));

        Map<Integer, String> map = users
                .stream()
                .collect(Collectors.toMap(
                        p -> p.getAge(),
                        p -> p.getName(),
                        (name1, name2) -> name1 + ";" + name2));

        System.out.println(map);
    }

    private static void test3() {

        List<User> users = new ArrayList();
        users.add(new User(1, "name" + 1, 10));
        users.add(new User(2, "name" + 2, 21));
        users.add(new User(3, "name" + 3, 34));
        users.add(new User(4, "name" + 4, 6));
        users.add(new User(5, "name" + 5, 55));
        users.add(new User(6, "name" + 6, 55));

        String phrase = users
                .stream()
                .filter(p -> p.getAge() >= 18)
                .map(p -> p.getName())
                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

        System.out.println(phrase);

    }

    private static void test2() {
        //流复用

        //复用
        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        streamSupplier.get().anyMatch(s -> true);   // ok
        streamSupplier.get().noneMatch(s -> true);  // ok

        //没复用
        Stream<String> stream =
                Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        stream.anyMatch(s -> true);    // ok
        stream.noneMatch(s -> true);   // exception
    }

    private static void test1() {
        //执行效率
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s));

        System.out.println("---------------------------");

        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        System.out.println("---------------------------");

        Stream.of("d2", "a2", "b1", "b3", "c")
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        System.out.println("---------------------------");

        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }

    private static void test() {
        Arrays.asList("a1", "a2", "a3")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);

        Arrays.stream(new int[] {1, 2, 3})
                .map(n -> 2 * n + 1)
                .average()
                .ifPresent(System.out::println);

        int sum = Arrays.stream(new int[]{1, 2, 3})
                .map(n -> 2 * n + 1)
                .sum();
        System.out.println(sum);
    }

    //根据Boolean来分组
    private static void partitioningBy() {
        List<User> users = new ArrayList();
        users.add(new User(1, "name" + 1, 10));
        users.add(new User(2, "name" + 2, 21));
        users.add(new User(3, "name" + 3, 34));
        users.add(new User(4, "name" + 4, 6));
        users.add(new User(5, "name" + 5, 55));
        users.add(new User(6, "name" + 6, 55));

        Map<Boolean, List<User>> collect = users.stream()
                .collect(Collectors.partitioningBy(p -> p.getAge() < 18));

        for(Map.Entry entry:collect.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }

    //分组
    private static void groupingBy() {
        List<User> users = new ArrayList();
        users.add(new User(1, "name" + 1, 10));
        users.add(new User(2, "name" + 2, 21));
        users.add(new User(3, "name" + 3, 34));
        users.add(new User(4, "name" + 4, 6));
        users.add(new User(5, "name" + 5, 55));
        users.add(new User(6, "name" + 6, 55));

        Map<Integer, List<User>> collect = users.stream().collect(Collectors.groupingBy(User::getAge));
        for(Map.Entry entry:collect.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    private static void generate() {
        //生成 10 个随机整数
        Random seed = new Random();
        Supplier<Integer> random = seed::nextInt;
        Stream.generate(random).limit(10).forEach(System.out::println);
        //生成一个等差数列
        Stream.iterate(0, n -> n + 3).limit(10).forEach(x -> System.out.print(x + " "));
    }

    private static void match() {
        List<User> users = new ArrayList();
        users.add(new User(1, "name" + 1, 10));
        users.add(new User(2, "name" + 2, 21));
        users.add(new User(3, "name" + 3, 34));
        users.add(new User(4, "name" + 4, 6));
        users.add(new User(5, "name" + 5, 55));

        boolean b = users.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b);

        boolean b1 = users.stream().anyMatch(e -> e.getAge() < 12);
        System.out.println(b1);

        boolean b2 = users.stream().noneMatch(e -> e.getAge() < 0);
        System.out.println(b2);
    }

    private static void minMaxDistinct() {
        List<String> list = new ArrayList();
        list.add("hello");
        list.add("hello");
        list.add("world");
        list.add("world");
        list.add("dge1992");
        list.add("iloveyou");
        int asInt = list.stream().mapToInt(String::length)
                .max()
                .getAsInt();
        System.out.println(asInt);
        int asInt2 = list.stream().mapToInt(String::length)
                .min()
                .getAsInt();
        System.out.println(asInt2);
        List<String> collect = list.stream()
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void sorted() {
        List<User> users = new ArrayList();
        for (int i = 1; i <= 5; i++) {
            User user = new User(i, "name" + i, i);
            users.add(user);
        }
        List<User> personList2 = users.stream().limit(2).sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).collect(Collectors.toList());
        System.out.println(personList2);
    }

    private static void skip2() {
        List<User> users = new ArrayList();
        for (int i = 10; i >= 5; i--) {
            User user = new User(i, "name" + i, i);
            users.add(user);
        }
        //先排序后过滤
        List<User> collect = users.stream().sorted((p1, p2) ->
                p1.getName().compareTo(p2.getName()))
                .limit(2).collect(Collectors.toList());
        System.out.println(collect);

        //先过滤后排序
        List<User> collect2 = users.stream().limit(2).sorted((p1, p2) ->
                p1.getName().compareTo(p2.getName()))
                .collect(Collectors.toList());
        System.out.println(collect2);
    }

    private static void skip() {
        List<User> users = new ArrayList();
        for (int i = 1; i <= 50; i++) {
            User user = new User(i, "name" + i, i);
            users.add(user);
        }
        List<User> collect = users.stream().skip(20).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
    }

    private static void limit() {
        List<User> users = new ArrayList();
        for (int i = 1; i <= 10000; i++) {
            User user = new User(i, "name" + i, i);
            users.add(user);
        }
        List<String> collect = users.stream().map(User::getName)
                .limit(10)
                .collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
    }

    /**
     * @author dongganen
     * @date 2019/7/26
     * @desc: 把Stream元素组合起来
     */
    private static void reduce() {
        //拼接字符串
        Optional<String> optional = Stream.of("A", "B", "C", "D")
                .reduce(String::concat);
        System.out.println(optional.get());

        String str = Stream.of("A", "B", "C", "D")
                .reduce("hello:", String::concat);
        System.out.println(str);

        //求最小值
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0)
                .reduce(Double.MAX_VALUE, Double::min);
        System.out.println(minValue);

        //求和
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        System.out.println(sumValue);

        //过滤，字符串连接
        String str2 = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
        System.out.println(str2);
    }

    /**
     * @author dongganen
     * @date 2019/7/26
     * @desc: 返回流中的第一个元素
     */
    private static void findFirst() {
        Optional<Integer> first = Stream.of(1, 2, 3, 4)
                .findFirst();
        System.out.println(first.get());
    }

    /**
     * @author dongganen
     * @date 2019/7/26
     * @desc: 留下偶数
     */
    private static void filter() {
        Integer[] integers = Stream.of(1, 2, 3, 4)
                .filter(e -> e % 2 == 0)
                .toArray(Integer[]::new);
        for(Integer i:integers){
            System.out.println(i);
        }

        List<String> list = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(System.out::println)
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * @author dongganen
     * @date 2019/7/26
     * @desc: map/flatMap
     */
    private static void map() {
        //转换成大写
        Stream<String> stream = Stream.of("a", "b", "c");
        List<String> list = stream.map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(list);

        int[] ints = IntStream.of(1, 2, 3).map(e -> e * e).toArray();
        System.out.println(ints[0]);
        System.out.println(ints[1]);
        System.out.println(ints[2]);

        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        inputStream.
                flatMap((childList) -> childList.stream())
                .forEach(System.out::println);

        Stream.of(
                Arrays.asList(new User(1, "dsa", 10), new User(5, "ljj", 30)),
                Arrays.asList(new User(2, "fnn", 18), new User(4, "wq", 50)),
                Arrays.asList(new User(3, "dge", 24))
        ).flatMap(e -> e.stream())
                .forEach(System.out::println);
    }

    /**
     * @author dongganen
     * @date 2019/7/26
     * @desc: 流的构造和转换
     */
    public static void structure() {
        //第一种方式
        Stream<String> stream = Stream.of("a", "b", "c");
        //第二种方式
        String[] str = new String[]{"a", "b", "c"};
        Stream<String> stream1 = Stream.of(str);
        Stream<String> stream2 = Arrays.stream(str);
        //第三种方式
        List<String> list = Arrays.asList(str);
        Stream<String> stream3 = list.stream();
    }

    /**
     * @author dongganen
     * @date 2019/7/26
     * @desc: 基本类型的数据流 IntStream、LongStream、DoubleStream
     */
    public static void basic() {
        IntStream.range(1, 10).forEach(System.out::println);
        IntStream.rangeClosed(1, 10).forEach(System.out::println);
        IntStream.of(3, 4, 5).forEach(System.out::println);
    }

    /**
     * @author dongganen
     * @date 2019/7/26
     * @desc: 流转换为其它数据结构
     */
    public static void streamToOther() {
        Stream<String> stream = Stream.of("a", "b", "c");
        String[] strings = stream.toArray(String[]::new);
        System.out.println(strings[0]);
        System.out.println(strings[1]);
        System.out.println(strings[2]);

        Stream<String> stream2 = Stream.of("a", "b", "c");
        List<String> list = stream2.collect(Collectors.toList());
        System.out.println(list);

        Stream<String> stream3 = Stream.of("a", "b", "c");
        Set<String> set = stream3.collect(Collectors.toSet());
        System.out.println(set);

        Stream<String> stream4 = Stream.of("a", "b", "c");
        Stack stack = stream4.collect(Collectors.toCollection(Stack::new));
        System.out.println(stack);

        Stream<String> stream5 = Stream.of("a", "b", "c");
        String str = stream5.collect(Collectors.joining());
        System.out.println(str);
    }

}
