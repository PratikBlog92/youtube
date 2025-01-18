package org.example;

import java.util.ArrayList;
import java.util.List;

public class FailFast {
//    Q.1 what is fail fast ??
//    Q.2 what is ConcurrentModificationException ??

//    if something being iterated and modified
//    at that time throws
//    ConcurrentModificationException
//    this approach called as fail fast

//    if you are traversing collection using iterator
//    and its get modified
//    then Iterator.next() method throw
//    ConcurrentModificationException

    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("coconut");
        fruits.add("kiwi");

//        for-each loop internally used Iterator

//        for (String elem : fruits) {
//            if (elem.equals("banana")) {
////                fruits.remove(elem);
//                fruits.add("pineapple");
//            }
//        }

        for (int i = 0; i < fruits.size(); i++) {
            if (fruits.get(i).equals("banana")) {
                fruits.remove(fruits.get(i));
            }
        }

        System.out.println(fruits);
    }
}