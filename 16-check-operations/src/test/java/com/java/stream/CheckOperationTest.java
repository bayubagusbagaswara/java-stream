package com.java.stream;

import org.junit.jupiter.api.*;

import java.util.List;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class CheckOperationTest {

    @Test
    @Order(1)
    @DisplayName("Membuat check operation untuk mengecek kecocokan data stream dengan suatu kondisi")
    void testAnyMatch() {
        boolean match = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

                .stream()

                // tambahkan operation anyMatch()
                // anyMatch artinya mengecek data streamnya cukup minimal SATU DATA saja yang memenuhi kondisi
                // apakah ada data yang memenuhi kondisi yang kita tentukan? jika ada maka true, jika tidak ada maka false
                // masukkan kondisi atau kriteria pengecekan data didalam function lambda anyMatch
                // misal kita cek semua number apakah lebih besar dari 20
                // Jika ada satu saja data di stream yang memenuhi kondisi di lambda, maka hasinya akan true
                // balikan anyMatch adalah boolean

                .anyMatch(number -> {
                    System.out.println("Number: " + number);
                    return number > 20;
                })
                ;
        System.out.println("Hasil anyMatch data: " + match); // hasilnya false, karena data stream tidak ada sama sekali yang datanya lebih dari 20
    }

    @Test
    @Order(2)
    @DisplayName("Membuat check operation untuk mengecek semua data stream")
    void testAllMatch() {
        // boolean match = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5)
        boolean match = List.of(2, 2, 3 , 3, 4, 4, 5, 11)

                .stream()

                // SEMUA DATA streamnya harus memenuhi kondisi, baru bisa true hasilnya
                // jika salah satu saja tidak memenuhi kondisi, maka hasilnya False
                // jadi harus semua data stream
                // berbeda dengan anyMatch yang cukup satu data yang memenuhi kondisi, maka nilainya true

                .allMatch(number -> {
                    System.out.println("Number: " + number);
                    // return number <= 5; // true, karena SEMUA DATA streamnya kurang dari atau sama dengan 5
                    return number <= 5; // false, karena ada SATU DATU yang lebih dari 5, yakni bernilai 11
                })
                ;
        System.out.println("Hasil allMatch data: " + match);
    }

    @Test
    @Order(3)
    @DisplayName("Membuat check operation untuk none match (tidak boleh memenuhi kondisi)")
    void testNoneMatch() {
        // boolean match = List.of(21, 22, 23, 24, 25, 26)
        boolean match = List.of(21, 22, 23, 24, 25, 19)
                .stream()

                // semua data di stream tidak boleh ada yang match
                // artinya tidak boleh ada data yang memenuhi kondisi, baru nilainya bisa true
                // jika ada SATU DATA saja, maka nilainya akan False
                // ini seperti kebalikan dari allMatch()

                .noneMatch(number -> {
                    // return number <= 20; // true, karena SEMUA DATA lebih dari 20, tidak ada data yang kurang dari atau sama dengan 20
                    System.out.println("Number: " + number);
                    return number <= 20; // false, karena ADA SATU DATA yang kurang dari atau sama dengan 20, yakni 19
                })
                ;
        System.out.println("Hasil noneMatch: " + match);
    }
}
