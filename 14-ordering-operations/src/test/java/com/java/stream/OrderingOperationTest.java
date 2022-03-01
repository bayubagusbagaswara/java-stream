package com.java.stream;

import org.junit.jupiter.api.*;

import java.util.Comparator;
import java.util.List;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class OrderingOperationTest {

    @Test
    @Order(1)
    @DisplayName("Membuat Ordering Sorted atau Pengurutan")
    void testSorted() {
        // create data list
        List.of("Gosling", "Albert", "Tesla", "Newton", "Faraday")

                // convert to stream
                .stream()

                // tambahkan operation sorted()
                // otomatis data streamnya akan diurutkan
                // ini termasuk Intermediate operation, artinya butuh terminal operation yakni forEach
                // balikan data sorted adalah data stream itu sendiri
                // contoh ini adalah Stream of String
                .sorted()

                // jalankan stream nya
                .forEach(System.out::println);
    }

    @Test
    @Order(2)
    @DisplayName("Membuat Ordering Sorted menggunakan Comparator")
    void testSortedWithComparator() {

        // buat sebuah Comparator dulu
        // jika datanya berupa String, maka buat juga Comparator dengan tipe generic String

        Comparator<String> reverseComparator = Comparator.reverseOrder(); // reverse atau descending
        Comparator<String> reverseComparator1 = Comparator.naturalOrder(); // ascending

        List.of("Gosling", "Albert", "Tesla", "Newton", "Faraday")

                // convert to stream
                .stream()

                // tambahkan operation sorted()
                // dan masukkan comparatornya
                .sorted(reverseComparator)

                // jalankan stream nya
                .forEach(System.out::println);
    }
}
