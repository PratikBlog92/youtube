package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class MapSortingByKeys {
    public static void main(String[] args) {

//      Q. Sorting map by keys. sort it by ASC and DESC order

        Map<String, Integer> map = new HashMap<>();
        map.put("Banana", 3);
        map.put("Apple", 1);
        map.put("Orange", 2);
        map.put("PineApple", 5);
        map.put("Kiwi",4);

        //TODO 1 Automatically sorts by key ASC
        Map<String, Integer> sortedMap1 = new TreeMap<>(map);

        //TODO 2 Sort by key in DESC order
        Map<String, Integer> sortedMap2 = new TreeMap<>
                (Collections.reverseOrder());
        sortedMap2.putAll(map);

        //TODO 3 Sort by key in ASC order - modern way
        Map<String, Integer> sortedMap3 = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,      // Extract keys
                        Map.Entry::getValue,    // Extract values
                        (e1, e2) -> e1, // Resolve duplicate keys by keeping the first value
                        LinkedHashMap::new));  // Use LinkedHashMap to preserve order

        //TODO 4 Sort by key in DESC order - modern way
        Map<String, Integer> sortedMap4 = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
        //------------------------------------------------------------------------
        List<Map.Entry<String, Integer>> sortedMap5 =
                new ArrayList<>(map.entrySet());

        // TODO 5 Sort by key in ASC order - List way
        sortedMap5.sort(Map.Entry.comparingByKey());

        // TODO 6 Sort by key in DESC order - List way
        sortedMap5.sort(Map.Entry.comparingByKey(Comparator.reverseOrder()));

        //TODO 7 Custom sorting
        sortedMap5.sort((key1, key2) -> key1.getKey().compareTo(key2.getKey()));

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : sortedMap5) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

//       why to use LinkedHashmap ??
//       if we use Object as key use equal and hashcode

    }
}
