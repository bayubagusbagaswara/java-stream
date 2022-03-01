package com.java.stream;

import org.junit.jupiter.api.*;

import java.util.Comparator;
import java.util.List;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class AggregateOperationTest {

    @Test
    @Order(1)
    @DisplayName("Membuat Aggregate operation untuk mencari nilai maximum")
    void testMax() {

        List.of("Albert", "Faraday", "Tesla", "Newton", "Ohm", "Gosling")
                .stream()

                // tambahkan operation max dan masukkan Comparator
                // Comparator digunakan untuk mengurutkan data sebelum di max
                // naturalOrder mengurutkan data stream secara ascending
                // jadi setelah diurutkan, lalu pilih data maximum nya
                // balikannya dari max adalah optional of string
                .max(Comparator.naturalOrder())

                // cetak hasil stream nya
                .ifPresent(x -> System.out.println(x));
    }

    @Test
    @Order(2)
    @DisplayName("Membuat Aggregate operation untuk mencari nilai minimum")
    void testMin() {
        List.of("Albert", "Faraday", "Tesla", "Newton", "Ohm", "Gosling")
                .stream()
                .min(Comparator.reverseOrder())
                .ifPresent(System.out::println);
    }

    @Test
    @Order(3)
    @DisplayName("Membuat Aggregate operation untuk menghitung jumlah data streamnya")
    void testCount() {
        // create data list of string
        // lalu converst stream untuk menghitung jumlah data di list
        // kemudian tampung hasil count nya didalam variable count bertipe long
        long count = List.of("Albert", "Faraday", "Tesla", "Newton", "Ohm", "Gosling")
                .stream()

                // count() balikannya adalah long bukan optional
                // karena jika data streamnya kosong, maka akan dihitung nol
                .count();

        System.out.println("jumlah data stream: " + count);
    }

    // Bisa juga membuat Aggregate Manual

    @Test
    @Order(4)
    @DisplayName("Membuat aggregate manual untuk menjumlah data streamnya")
    void testSum() {
        var result = List.of(1, 3, 6, 9, 12)
                .stream()

                // harus memberi inisial data pertamanya berapa
                // misalnya data pertama adalah 0
                .reduce(0,(value, item) -> {
                    System.out.println("Value= " + value + ", item= " + item);
                    return value + item;
                });

        System.out.println("Hasil SUM item : " + result);

        // inisial kondisi awal 0
        // 1. value=0, item=1 -> 1
        // 2. value=1, item=3 -> 4
        // 3. value=4, item=6 -> 10
        // 4. value=10, item=9 -> 19
        // 5. value=19, item=12 -> 31
    }

    @Test
    @Order(5)
    @DisplayName("Membuat aggregate manual untuk Factorial")
    void testFactorial() {
        var factorial = List.of(1, 2, 3, 4, 5)
                .stream()

                // faktorial kondisi awalnya harus 1
                // karena jika nol, maka hasilnya semua akan nol
                .reduce(1, (value, item) -> {
                    System.out.println("Value= " + value + ", item= " + item);
                    return value * item;
                });

        System.out.println("Hasil faktorial: " + factorial);
        // inisial value 1
        // 1. value=1 item=1 -> 1
        // 2. value=1 item=2 -> 2
        // 3. value=2 item=3 -> 6
        // 4. value=6 item=4 -> 24
        // 5. value=24 item=5 -> 120
    }
}
