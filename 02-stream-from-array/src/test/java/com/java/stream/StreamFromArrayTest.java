package com.java.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamFromArrayTest {

    @Test
    @DisplayName("Create Stream from Array Data")
    void testCreateStreamFromArray() {

        // Sebenarnya method Stream.of() itu bisa memasukkan data lebih dari satu, karena parameter method nya adalah variadict argument
        // Contoh membuat stream dari data array berupa String

        Stream<String> arrayStream = Stream.of("Albert", "Tesla", "Gosling");

        // Contoh membuat stream dari data array berupa Integer

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        // Bisa juga melakukan konversi dari array menjadi stream
        // Misal kita sudah punya data Array nya, kemudian kita ingin melakukan konversi menjadi stream
        // Cara konversinya cukup pakai method stream() milik arrays, dan masukkan data array nya

        String[] dataArray = new String[]{
                "Ohm", "Faraday", "Galileo"
        };
        Stream<String> streamFromArray = Arrays.stream(dataArray);
    }
}
