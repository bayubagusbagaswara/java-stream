package com.java.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class StreamPipelineTest {

    @Test
    @DisplayName("Create stream pipeline manual")
    void testCreateStreamPipeline() {

        // biasanya kita membuat data untuk stream nya
        // misal dari array atau turunan Collection seperti List
        List<String> list = List.of("Apple", "Mango", "Orange", "Starfruit", "Watermelon");

        // lalu kita lakukan konversi dari list menjadi stream
        // balikannya adalah Stream of String
        Stream<String> stream = list.stream();

        // kemudian kita tambahkan operation untuk data stream nya
        // misal operation untuk transform data stream nya menjadi UPPERCASE
        Stream<String> streamUpper = stream.map(name -> {
            return name.toUpperCase();
        });

        // lalu misalnya kita ingin menambahkan operation lagi untuk data streamnya
        // misal kita ingin menambahkan kata "Mr" ke masing-masing data stream hasil operation UPPER
        Stream<String> streamMr = streamUpper.map(upper -> "Mr." + upper);

        // diakhiri dengan forEach untuk menjalankan stream nya, agar datanya mengalir
        streamMr.forEach(System.out::println);
    }

    // Tapi sebenarnya seorang Java Developer tidak pernah pake cara diatas, atau manual dalam melakukan stream pipeline
    // Biasanya lebih menggunakan metode chaining, atau menggabungkan jadi satu perintah untuk stream
    // seperti menjadi satu baris, makanya disebut dengan Stream Pipeline
    // artinya seperti data stream yang mengalir dalam pipa

    @Test
    @DisplayName("Create Stream Pipeline with Chaining")
    void testCreateStreamPipelineOk() {

        // misal kita ingin melakukan konversi menjadi Stream of String
        // kemudian kita tambahkan beberapa operation untuk data stream nya
        // diakhiri dengan forEach
        // membuat data untuk stream dan perintah konversi ke data stream harus dipisah
        List<String> list = List.of("Apple", "Orange", "Mango", "Avocado", "Cherry");

        list.stream()
                .map(String::toUpperCase)
                .map(upper -> "Mr." + upper)
                .forEach(System.out::println);
    }
}
