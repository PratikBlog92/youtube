package org.example;

import java.util.HashMap;
import java.util.Map;

public class DuplicateWordCounter {
    public static void main(String[] args) {
//   Q. Java program to count duplicate words in a string

        String input = "my name is pratik. He love programming...!" +
                " He currently writting, " +
                "Java program to count duplicate words in a string ";

        String cleanedInput = input.toLowerCase()
                .replaceAll("[^a-zA-Z ]", "");

        // Split the string into words
        String[] words = cleanedInput.split("\\s+");

        // Create a HashMap to store word counts
        Map<String, Integer> wordCountMap = new HashMap<>();


        //TODO way 1
        for (String word : words) {
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }


        // TODO Way 2
//        for (String word : words) {
//            wordCountMap.put(word,
//                    wordCountMap.getOrDefault(word, 0) + 1);
//        }
//        System.out.println(wordCountMap);


        //TODO way 3
//        Map<String, Long> wordCount = Arrays.stream(
//                cleanedInput.split("\\s+"))
//                .collect(Collectors.groupingBy
//                        (Function.identity(), Collectors.counting()));
//
//        System.out.println(wordCount);


        //TODO way 4 convert it to integer
//        wordCountMap = Arrays.stream(cleanedInput.split("\\s+"))
//                .collect(Collectors.groupingBy(
//                        Function.identity(),
//                        Collectors.collectingAndThen(
//                                Collectors.counting(), Long::intValue)
//                ));
    }
}
