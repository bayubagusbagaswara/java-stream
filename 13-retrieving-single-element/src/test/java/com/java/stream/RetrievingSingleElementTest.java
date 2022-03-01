package com.java.stream;

import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class RetrievingSingleElementTest {

    @Test
    @Order(1)
    @DisplayName("Membuat Retrieving Operation Find Any")
    void testFindAny() {
        // buat data List, konversi langsung menjadi stream
        // dan tambahkan operation findAny
        // findaAny() mengambil datanya secara RANDOM
        // balikan dari findAny ini adalah Optional
        // artinya datanya bisa ADA atau bisa TIDAK ADA
        Optional<String> optional = List.of("Albert", "Faraday", "Newton", "Tesla", "Gosling")
                .stream()
                .findAny();
        // untuk mengambil datanya bisa menggunakan get()
        // tapi kalau datanya tidak ada, maka dia bisa try exception

        // optional.get(); // kalau datanya tidak ada, dia bisa try exception

        // cara lain untuk mengambil datanya adalah menggunakan ifPresent()
        // bedanya meski menemui data kosong, maka tidak terjadi error
        // karena hanya mengambil jika datanya memang ada
        optional.ifPresent(name -> {
            System.out.println(name);
        });

        // ini sudah pasti otomatis ditrigger streamnya agar berjalan, tidak perlu menggunakan forEach
    }

    @Test
    @Order(2)
    @DisplayName("Membuat Retrieving Operation Find First")
    void testFindFirst() {
        Optional<String> optional = List.of("Albert", "Faraday", "Newton", "Gosling", "Tesla")

                // convert to stream
                .stream()

                // findFirst artinya hanya mengambil element pertama
                // yang diambil selalu data pertama
                // balikan data findFirst adalah optional
                .findFirst();

        // mengambil data optional menggunakan ifPresent
        optional.ifPresent(name -> {
            System.out.println(name);
        });
    }
}
