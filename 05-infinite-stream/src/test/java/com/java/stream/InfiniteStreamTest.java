package com.java.stream;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class InfiniteStreamTest {

    @Test
    void testCreateInfiniteStream() {

        // Infinite Stream adalah stream yang tidak aja ujungnya
        // artinya stream akan diekseksui tidak pernah berhenti
        // jadi akan mengalir terus menerus (mengalirkan data return value nya, dimana retur nya menggunakan lambda supplier)
        // harus paksa stop agar berhenti

        // Stream ini akan mengalirkan terus data, tapi isinya hanya data yang di return kan
        // menggunakan lambda supplier

        Stream<String> stream = Stream.generate(() -> {
            return "Data supplier";
        });

        // jika kita forEach, maka stream akan berjalan, dan tidak pernah berhenti
        // stream.forEach(System.out::println);

        // Ada juga Stream interate
        // kegunaannya untuk mengirimkan return data pertama ke data yang kedua
        // memiliki 2 parameter, yakni parameter pertama adalah data yang akan kita kirim dalam operator ini
        // misal pertama kita akan mengirim data 1
        // 1 akan jadi value pertamanya
        // kemudian di dalam lambda function kita return value + 1
        // itu akan terus berulang, dan lanjut iterasi selanjutnya
        // hasilnya 1,2,3,4,5,.... tidak pernah berhenti

        Stream<Integer> iterate = Stream.iterate(1, value -> {
            return value + 1;
        });

        // bila kita jalankan stream nya dengan forEach, maka akan terus berjalan tanpa henti

        iterate.forEach(System.out::println);
    }
}
