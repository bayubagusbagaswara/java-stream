package com.java.stream;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class StreamFromCollectionTest {

    // Stream bisa dibuat dari Collection, seperti List, Set dll
    // Setiap kita membuat Collection, baik itu List, Set, atau yang lainnya, pasti Collection itu punya method yang namanya stream()
    // Oleh karena itu, dia akan otomatis konversi dari collection menjadi sebuah stream

    @Test
    void testCreateStreamFromCollection() {

        // Pertama, kita buat dulu collection, misalnya dari List
        // dimana List adalah turunan dari collection
        // kita bikin Collection of String, artinya data collection yang isinya adalah data string

        Collection<String> collection = List.of("Albert", "Tesla", "Faraday", "Galileo", "Newton");

        // Kedua, lakukan konversi
        // untuk melakukan konversi dari Collection of String menjadi Stream of String, cukup gunakan method stream()
        // hasil balikannya sudah Stream of String

        Stream<String> stringStream = collection.stream();

        // Ketiga, jalankan atau eksekusi stream nya menggunakan forEach(), hasilnya sudah berupa String

        stringStream.forEach(System.out::println);

        // karena Stream itu aliran, artinya hanya bisa digunakan sekali saja
        // jika kita gunakan stream nya lagi, maka akan terjadi error

        // stringStream.forEach(System.out::println); // ini menyebabkan ERROR

        // solusinya adalah dengan membuat stream lagi
        // misalnya buat stream2, meskipun stream2 memiliki data yang sama dengan stream1

        Stream<String> stringStream2 = collection.stream();
        stringStream2.forEach(System.out::println);
    }
}
