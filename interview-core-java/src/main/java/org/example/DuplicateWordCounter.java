package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateWordCounter {
    public static void main(String[] args) {
//   Q. Java program to count duplicate words in a string

        String input = "The new phone has amazing features. " +
                "The battery life is excellent, " +
                "and the camera quality is outstanding. " +
                "However, the price is a bit too high. " +
                "Overall, the phone offers great value for " +
                "those who can afford it.";

        String cleanedInput = input.toLowerCase()
                .replaceAll("[^a-zA-Z ]", "");

        // Split the string into words
        String[] words = cleanedInput.split("\\s+");

        // Create a HashMap to store word counts
        Map<String, Integer> wordCountMap = new HashMap<>();


        //TODO way 1
//        for (String word : words) {
//            if (wordCountMap.containsKey(word)) {
//                wordCountMap.put(word, wordCountMap.get(word) + 1);
//            } else {
//                wordCountMap.put(word, 1);
//            }
//        }


        // TODO Way 2
//        for (String word : words) {
//            wordCountMap.put(word,
//                    wordCountMap.getOrDefault(word, 0) + 1);
//        }
//        System.out.println(wordCountMap);


        //TODO way 3
        Map<String, Long> wordCount = Arrays.stream(
                cleanedInput.split("\\s+"))
                .collect(Collectors.groupingBy
                        (Function.identity(), Collectors.counting()));

        System.out.println(wordCount);


        //TODO way 4 convert it to integer
        wordCountMap = Arrays.stream(cleanedInput.split("\\s+"))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.collectingAndThen(
                                Collectors.counting(), Long::intValue)
                ));

        System.out.println(wordCountMap);
    }
}
