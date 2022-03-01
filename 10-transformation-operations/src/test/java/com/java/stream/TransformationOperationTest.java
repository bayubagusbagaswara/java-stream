package com.java.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class TransformationOperationTest {

    @Test
    @DisplayName("Membuat Transformation Operation menggunakan Map")
    void testMap() {

        // buat data List
        List.of("Albert", "Faraday", "Tesla", "Newton")

                // konversi dari data list menjadi Stream of String
                .stream()

                // ubah (transform) data stream menjadi UPPER
                // Map akan membuat stream baru (balikan data streamnya) yang datanya adalah string hasil UPPER
                .map(name -> name.toUpperCase())

                // ubah (transform) lagi dari data stream UPPER menjadi Stream of Integer
                // karena ingin menghitung panjang karakter tiap data streamnya
                .map(upperName -> upperName.length())

                // jalankan streamnya
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("Membuat Transformation Operation menggunakan FlatMap")
    void testFlatMap() {

        // buat data List
        List.of("Albert", "Faraday", "Galileo", "Tesla", "Newton")

                // konversi dari data list menjadi Stream of String
                .stream()

                // ubah data stream menjadi UPPERCASE
                // balikannya adalah berupa data stream yang sudah UPPERCASE, bukan Stream lain
                .map(name -> {
                    System.out.println("Name : " + name);
                    return name.toUpperCase();
                })

                // flatMap itu wajib harus dibalikkan stream lagi
                // tidak bisa melakukan flatMap seperti kode program dibawah ini
                // ini akan error, karena balikannya adalah length yakni nilai panjang

                 // .flatMap(upper -> upper.length()); // INI ERROR

                // jadi balikan flatMap harus berupa Stream, entah itu Stream empty atau kosong datanya
                // contoh kode program dibawah ini bisa dilakukan untuk flatMap


                /* =========================
                 .flatMap(upper -> {
                     // balikannya adalah Stream yang berisi data length, atau Stream of Integer
                     return Stream.of(upper.length());
                 })
                 =========================== */

                /* ========================
                 .flatMap(length -> {
                     return System.out.println(length);
                 })
                 =========================*/

                // jika balikan flatMap adalah Stream yang lebih dari satu stream, maka akan dimerger menjadi satu
                .flatMap(upperName -> {

                    // didalam flatMap akan mengembalikan 2 stream
                    // yakni data stream UPPERCASE sebelumnya dan data length, atau Stream of Serializable dan Comparable

                    System.out.println("upperName: " + upperName);
                    return Stream.of(upperName, upperName.length());
                })

                // lalu misal kita ingin menduplikat streamnya sebanyak 3 kali
                // jadi tiap data upperName di copy 3 kali, dan data length juga di copy 3 kali
                .flatMap(value -> {
                    return Stream.of(value, value, value);
                })

                // jalankan streamnya
                .forEach(System.out::println);
    }
}
