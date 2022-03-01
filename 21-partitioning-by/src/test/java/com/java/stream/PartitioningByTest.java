package com.java.stream;

import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class PartitioningByTest {

    @Test
    @DisplayName("Membuat Partitioning By dari data Stream of Integer")
    void testPartitioningByStreamOfInteger() {
        // balikan dari partitioningBy adalah boolean
        // jadi balikannya bukan Key yang biasanya berupa String atau Integer

        Map<Boolean, List<Integer>> map = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .collect(Collectors.partitioningBy(number -> {

                    // jika data stream number > 5 (lebih dari 5), maka bernilai true
                    // data stream yang kurang dari 5, maka bernilai false
                    return number > 5;
                }));

        map.forEach(new BiConsumer<Boolean, List<Integer>>() {
            @Override
            public void accept(Boolean aBoolean, List<Integer> integers) {
                System.out.println("Boolean: " + aBoolean + ", Value: " + integers);
            }
        });

        for (var data: map.entrySet()) {
            for (var value : data.getValue()) {
                System.out.println("Boolean : " + data.getKey() + ", Value di List : " + value);
            }
            System.out.println("=======================");
        }
    }

    @Test
    @DisplayName("Membuat Partitioning By dari data Stream of String")
    void testPartitioningByStreamOfString() {

        Map<Boolean, List<String>> map = Stream.of("Albert", "Ohm", "Faraday", "Tesla", "Newton")
                .collect(Collectors.groupingBy(name -> {

                    // jika name.length > 4 maka nilainya true
                    return name.length() > 5;

                }));

        System.out.println(map);
    }
}
