package com.java.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class ExecutionStreamTest {

    // Membuat Single Stream dan Menjalankannya menggunakan forEach
    @Test
    void testCreateEmptyOrSingleStream() {

        // create stream empty
        Stream<String> emptyStream = Stream.empty();

        // menjalankan stream, hasilnya stream kosong
        emptyStream.forEach(System.out::println);

        // create stream single data
        Stream<String> oneStream = Stream.of("Albert");

        // menjalankan stream, hasil dari eksekusi stream adalah data stream itu sendiri
        oneStream.forEach(System.out::println);

        // create stream dengan ofNullable()
        String data = null;
        Stream<String> emptyOrNotStream = Stream.ofNullable(data);

        // menajalankan stream, dan hasilnya kosong, karena datanya emang berisi null
        emptyOrNotStream.forEach(System.out::println);
    }

    // Membuat Stream from Array dan mengeksekusi menggunakan forEach
    @Test
    void testCreateStreamFromArray() {

        // create stream from Array of String
        Stream<String> arrayStream = Stream.of("Albert", "Galileo", "Faraday");

        // jalankan stream
        arrayStream.forEach(System.out::println);

        // create stream from Array of Integer
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        // jalankan stream
        integerStream.forEach(System.out::println);

        // create data Array of String
        String[] dataArray = new String[]{
                "Newton", "Tesla", "Gosling", "Ludwig"
        };

        // convert data array to stream
        Stream<String> streamFromArray = Arrays.stream(dataArray);

        // jalankan stream
        streamFromArray.forEach(System.out::println);
    }
}
