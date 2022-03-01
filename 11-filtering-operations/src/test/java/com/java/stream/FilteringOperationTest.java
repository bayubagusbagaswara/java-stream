package com.java.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FilteringOperationTest {

    @Test
    @DisplayName("Membuat filtering operation untuk data stream")
    void testFilter() {

        // buat data List of String
        List.of("Albert", "Faraday", "Tesla", "Newton", "Galileo")

                // konversi data list menjadi Stream of String
                .stream()

                // buat filter operation
                // maka data stream akan melewati operation ini dan difilter
                // tentukan kriteria untuk data streamnya di operation filter ini
                // misal, panjang data streamnya harus lebih besar dari 4
                // jika tidak memenuhi kriteria, maka data stream akan dihapus
                .filter(name -> {
                    System.out.println("Name : " + name);
                    // setiap ketemu data yang memenuhi kondisi, maka langsung balikkan
                    // kondisinya adalah jika panjang name itu lebih dari 4
                    // Jika kurang dari 4, maka jangan balikan datanya
                    return name.length() > 4;
                })

                // jalankan streamnya
                .forEach(x -> {
                    System.out.println("Name > 4 is : " + x);
                    System.out.println();
                });

        // bisa juga buat data List of Integer

        List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

                // konversi ke stream of string
                .stream()

                // filter operation untuk data number yang genap
                .filter(number -> number % 2 == 0)

                // jalankan stream nya
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("Membuat distinct operation untuk menghapus duplikat pada data stream")
    void testDistinct() {
        List.of("Albert", "Faraday", "Tesla", "Tesla", "Gosling", "Newton", "New")

                // konversi ke stream of string
                .stream()

                // artinya jika ada data yang kembar, maka hanya dipilih satu saja
                // tidak ada duplikat dalam data streamnya
                .distinct()

                // jalankan stream nya
                .forEach(System.out::println);
    }
}
