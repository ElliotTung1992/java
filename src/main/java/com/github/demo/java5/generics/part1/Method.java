package com.github.demo.java5.generics.part1;

public class Method {

    public static void main(String[] args) {
        Pair<String, Integer> pair1 = new Pair<>("汽车", 1);
        Pair<String, Integer> pair2 = new Pair<>("汽车", 1);
        boolean compare = Util.compare(pair1, pair2);
        System.out.println(compare);
    }
}

class Util{

    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }
}

class Pair<K, V>{
    private K key;
    private V value;
    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }
    public void setKey(K key) {
        this.key = key;
    }
    public V getValue() {
        return value;
    }
    public void setValue(V value) {
        this.value = value;
    }
}
