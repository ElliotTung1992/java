package com.github.demo.java8.functional_interface;

import com.github.demo.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Author 小眼睛带鱼
 * @Description 函数式街接口实例
 * @Date 2019/8/1
 **/
public class Test2 {

    public static void main(String[] args){
        testMap();
        testDistinctByKey();
    }

    private static void testMap() {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        System.out.println(map.putIfAbsent(1, true));
        map.putIfAbsent(1, false);

        System.out.println(map.get(1));
    }

    private static void testDistinctByKey() {
        List<User> users = new ArrayList();
        users.add(new User(1, "name" + 1, 10));
        users.add(new User(2, "name" + 2, 21));
        users.add(new User(3, "name" + 3, 34));
        users.add(new User(4, "name" + 4, 6));
        users.add(new User(5, "name" + 5, 55));
        users.add(new User(6, "name" + 6, 55));

        List<User> collect = users.stream()
                .filter(distinctByKey(User::getAge))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

}
