package com.java.stream;

import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@DisplayName("Test Grouping By")
public class GroupingByTest {

    @Test
    @Order(1)
    @DisplayName("Membuat Grouping By dari data Stream of Integer")
    void testGroupingBy() {

        // buat data stream dan grouping datanya
        // grouping berdasarkan kondisi yang kita tentukan

        // Key nya String, dan Value nya adalah data yang di stream nya

        Map<String, List<Integer>> collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                // kita grouping menjadi 2, yakni group Besar dan group Kecil
            .collect(Collectors.groupingBy(number -> {
                if (number > 5){
                    // group key nya adalah besar
                    return "Besar";
                } else {
                    // group key nya adalah kecil
                    return "Kecil";
                }
            }));

        // ambil dan tampilkan data map nya

        collect.forEach(new BiConsumer<String, List<Integer>>() {
            @Override
            public void accept(String key, List<Integer> value) {
                System.out.println("Key: " + key + ", Value: " + value);
            }
        });
    }

    @Test
    @Order(2)
    @DisplayName("Membuat Grouping By dari data Stream of String")
    void testGroupingBy2() {
        Map<String, List<String>> map = Stream.of("Albert", "Tesla", "Ohm", "Newton", "Faraday", "Gosling")
                .collect(Collectors.groupingBy(name -> {
                    if (name.length() > 5){
                        return  "Panjang";
                    } else {
                        return "Pendek";
                    }
                }));
        map.forEach(new BiConsumer<String, List<String>>() {
            @Override
            public void accept(String key, List<String> value) {
                System.out.println("Key : " + key + ", Value: " + value);
            }
        });
    }

    @Test
    @Order(3)
    @DisplayName("Grouping by Ganjil dan Genap")
    void testGanjilGenap() {

        // balikan datanya adalah Map
        // dimana Key nya adalah data String dari kondisi atau group yang kita tentukan
        // dan Valuenya adalah data stream, yang kemudian value akan di konversi dari data stream menjadi collection List of Integer

        Map<String, List<Integer>> map = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .collect(Collectors.groupingBy(number -> {
                    if (number % 2 == 0) {
                        return "Genap";
                    } else {
                        return "Ganjil";
                    }
                }));

        map.forEach(new BiConsumer<String, List<Integer>>() {
            @Override
            public void accept(String key, List<Integer> value) {
                System.out.println("Key : " + key + ", Value : " + value);
            }
        });

        System.out.println("=======================");
        // foreach pertama untuk mecah map, hasilnya Key dan List[....]
        // foreach kedua untuk mecah data List nya menjadi satu persatu

        for (var data : map.entrySet()) {
            for (var value : data.getValue()) {
                System.out.println("Key : " + data.getKey() + ", Value di List : " + value);
            }
            System.out.println("=======================");
        }
    }
}
