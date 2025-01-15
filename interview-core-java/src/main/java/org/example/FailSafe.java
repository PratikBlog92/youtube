package org.example;

import java.util.ArrayList;
import java.util.List;

public class FailSafe {
//    Q.3 what is fail-safe ??

//    Fail-safe iterators don't throw exceptions when structural
//    changes happen to the collection of interest,
//    because they work with a clone, not the collection itself.

//    The key benefit provided by a fail-safe iterator is the
//    fact that they minimize the possibility of exceptions being thrown.
//    But that benefit comes with a cost, one of which is increased memory requirement

//    Disadvantages
//    1. Iterator isn’t guaranteed to return updated data from the Collection,
//      as it’s working on the clone instead of the actual Collection
//    2. It consumes more memory and time
    public static void main(String[] args) {
        List<String>  fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("coconut");
        fruits.add("kiwi");


        for (int i = 0; i < fruits.size(); i++) {
            if (fruits.get(i).equals("banana")) {
                fruits.remove(fruits.get(i));
            }
        }

        System.out.println(fruits);
    }
}