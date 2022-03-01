package com.java.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class StreamOperationsTest {

    @Test
    @DisplayName("Create Stream Operations")
    void testStreamOperation() {

        // create data dari List (Collection)

        List<String> names = List.of("Albert", "Faraday", "Newton", "Tesla");

        // konversi data List menjadi data stream
        // balikannya sudah Stream of string
        Stream<String> streamNames = names.stream();

        // Map
        // pertama, ambil tiap data dari stream names, kemudian simpan di name
        // satu persatu data stream akan diubah menjadi UPPERCASE

        Stream<String> streamUpper = streamNames.map(name -> {
            return name.toUpperCase();
        });

        // Jalankan stream nya, dan cetak data stream hasil operation

        streamUpper.forEach(value -> {
            System.out.println(value);
        });

        // Akan tetapi, jika kita ingin menampilkan data Names, maka tetap tidak berubah data aslinya
        // jadi names itu sama saja di data List maupun data Stream
        // karena dari List kita konversi ke stream
        // sehingga data stream awal tetap tidak berubah

        // data stream awal masih tetap
        names.forEach(System.out::println);

        // karena sebenarnya stream operations itu akan membuatkan stream baru
        // dan stream yang asli datanya tetap tidak berubah
    }
}
