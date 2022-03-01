package com.java.stream;

import org.junit.jupiter.api.*;

import java.util.stream.Stream;

public class ParallelStreamTest {

    @Test
    @DisplayName("Membuat Stream dijalankan secara Sequential")
    void testSequential() {

        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .forEach(number -> {
                    // tidak ada operation parallel, hanya running stream biasa
                    // untuk melihat Thread yang di running saat ini
                    // data stream hanya akan dirunnig dalam thread main secara bergantian
                    System.out.println(Thread.currentThread().getName() + " : " + number);
                });
    }

    @Test
    @DisplayName("Membuat Stream dijalankan secara Parallel")
    void testParallel() {

        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

                // menambahkan operation parallel()
                // artinya kita akan melakukan running streamnya secara paralel
                // balikan parallel() adalah data stream itu sendiri
                .parallel()

                .forEach(number -> {
                    // liat data stream di running dalam Thread yang bersamaan
                    // data stream akan running di ForkJoinPool, dan runningnya secara paralel
                    System.out.println(Thread.currentThread().getName() + " : " + number);
                });
    }
}
