package com.github.demo.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 函数接口
 */
public class Java8Test7 {

    public static void main(String[] args) {
        //使用函数接口
//        test1();
        //内置函数接口
        test2();
        //创建自定义函数接口
        test3();
        //创建自定义函数接口
//        test4();
        //使用内置函数接口实现
        tsst5();
    }

    private static void tsst5() {
        Order order = new Order(Arrays.asList(
                new OrderItem(1, 1225),
                new OrderItem(2, 983),
                new OrderItem(3, 1554)
        ));
        order.transformAndPrint2(new Function<Stream<OrderItem>, Stream<OrderItem>>() {
            @Override
            public Stream<OrderItem> apply(Stream<OrderItem> orderItemStream) {
                return orderItemStream.sorted(Comparator.comparing(OrderItem::getPrice));
            }
        });
        //简化
        order.transformAndPrint2(orderItemStream -> orderItemStream.sorted(Comparator.comparing(OrderItem::getPrice)));
    }

    private static void test4() {
        Order order = new Order(Arrays.asList(
                new OrderItem(1, 1225),
                new OrderItem(2, 983),
                new OrderItem(3, 1554)
        ));
        order.transformAndPrint(new Transformer<Stream<OrderItem>>() {
            @Override
            public Stream<OrderItem> transform(Stream<OrderItem> orderItems) {
                return orderItems.sorted(Comparator.comparing(OrderItem::getPrice));
            }
        });
    }

    private static void test3() {

    }

    private static void test2() {
    }

    private static void test1() {
        //使用匿名函数
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("创建了一个线程");
            }
        }).start();

        new Thread(() -> {
            System.out.println("创建了一个线程");
        }).start();
    }
}

/**
 * 自定义函数接口
 * @param <T>
 */
@FunctionalInterface
interface Transformer<T>{
    T transform(T input);
}


class OrderItem {
    private Integer id;
    private Integer price;

    public OrderItem(Integer id, Integer price) {
        this.id = id;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}

class Order {
    List<OrderItem> orderItems;

    public Order(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void transformAndPrint(Transformer<Stream<OrderItem>> streamTransformer){
        streamTransformer.transform(orderItems.stream())
                .forEach(System.out::println);
    }

    public void transformAndPrint2(Function<Stream<OrderItem>, Stream<OrderItem>> transformOrderItems){
        transformOrderItems.apply(orderItems.stream())
                .forEach(System.out::println);
    }
}
