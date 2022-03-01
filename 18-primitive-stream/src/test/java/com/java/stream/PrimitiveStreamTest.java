package com.java.stream;

import org.junit.jupiter.api.*;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class PrimitiveStreamTest {

    @Test
    @Order(1)
    @DisplayName("Membuat sebuah data stream dari tipe data primitive")
    void testCreate() {

        // membuat integer stream
        // method range untuk perulangan data integernya
        // jadi dimulai data integer 1 - 99 akan dikonversi menjadi stream of integer
        IntStream intStream = IntStream.range(1, 100);

        // untuk menjalankan data stream nya menggunakan forEach
        intStream.forEach(value -> {
            System.out.println("Data integer : " + value);
        });

        // membuat long stream
        LongStream longStream = LongStream.of(1, 2, 3, 4);
        longStream.forEach(dataLong -> {
            System.out.println("Data long : " + dataLong);
        });

        // membuat double stream
        // bisa menggunakan builder
        // artinya data stream juga bisa kita masukan secara satu persatu
        DoubleStream doubleStream = DoubleStream
                .builder()
                .add(0.1)
                .add(0.2)
                .build();
        doubleStream.forEach(dataDouble -> {
            System.out.println("Data double : " + dataDouble);
        });
    }

    // Primitve Stream Operations
    // semua operator stream untuk tipe data object, bisa juga digunakan untuk primitive stream class
    // ada beberapa operator yang lebih sederhana, seperti untuk aggregate, kita tidak perlu menggunakan comparator lagi
    // bahkan ada operator average() untuk menghitung rata-rata di primitive stream
    // cara pembuatan primitive stream pun hampir mirip dengan Stream biasa
    // kita bisa gunakan static method di class nya, misal IntStream.of(..), IntStream.builder() dan lain-lain

    @Test
    @Order(2)
    @DisplayName("Membuat operation untuk data stream primitive")
    void testOperations() {

        // di IntStream terdapat method average() yang digunakan untuk menghitung rata-rata
        // bahkan di Stream biasa (untuk tipe data Object) method average tersebut tidak ada
        IntStream intStream = IntStream.range(1, 100);

        // tambahkan operation average()
        // balikan dari average adalah Optional
        OptionalDouble optionalDouble =  intStream.average();

        // balikan ifPresent adalah void jadi tidak bisa di chaining dengan average()
        optionalDouble.ifPresent(average -> {
            System.out.println("Average: " + average);
        });
    }

    @Test
    @Order(3)
    @DisplayName("Konversi dari Primitive menjadi Stream Object")
    void convertPrimitiveToObjectStream() {
        // menggunakan method yang ada ToObj()
        // bertugas untuk mengkonversi dari stream tipe data primitive menjadi stream tipe data object
        IntStream.range(0, 100)
                .mapToObj(number -> "Number : " + number)
                .forEach(System.out::println);
    }

    @Test
    @Order(4)
    @DisplayName("Membuat operation untuk tipe data primitive stream cara simple")
    void testOperationSimple() {

        // integer stream
        IntStream.range(1,50)
                .average()
                .ifPresent(System.out::println)
        ;

        // double stream
        DoubleStream.of(0.5, 0.2, 0.5, 0.7, 0.8)
                .distinct()
                .map(z -> {
                    return z * 2;
                })
                .forEach(System.out::println)
        ;

        // integer stream map to object String
        IntStream.builder()
                .add(100)
                .add(20)
                .add(50)
                .build()
                .mapToObj(number -> "Number: " + number)
                .forEach(System.out::println)
        ;
    }
}
