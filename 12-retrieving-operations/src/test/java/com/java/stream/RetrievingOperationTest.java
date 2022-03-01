package com.java.stream;

import org.junit.jupiter.api.*;

import java.util.List;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class RetrievingOperationTest {

    @Test
    @Order(1)
    @DisplayName("Membuat Limit operation data stream")
    void testLimit() {

        // buat data List
        List.of("Albert", "Faraday", "Tesla", "Newton", "Gosling")

                // konversi menjadi data stream
                .stream()

                // buat operation limit, artinya mengambil data terbatas
                // misalnya mengambil 2 data pertama
                // balikan data dari limit adalah data stream itu sendiri yang sudah melalui operation
                // jadi datanya tetap sama dengan List of String
                .limit(2)

                // jalankan streamnya
                .forEach(System.out::println);
    }

    @Test
    @Order(2)
    @DisplayName("Membuat Skip operation data stream")
    void testSkip() {
        List.of("Albert", "Faraday", "Newton", "Tesla", "Gosling")

                // konversi menjadi Stream of String
                .stream()

                // skip artinya kita melewatkan sebuah data stream
                // misalnya kita lewatkan 2 data pertama
                // artinya pengambilan data yang dilakukan oleh operation ini dimulai dari data ke 3
                .skip(2)

                // jalankan streamnya
                .forEach(System.out::println);
    }

    @Test
    @Order(3)
    @DisplayName("Membuat TakeWhile (Ambil Selama) operation data stream")
    void testTakeWhile() {
        // create data list
        List.of("Albert", "Faraday", "Newton", "Tesla", "Gosling")

                // konversi menjadi Stream of String
                .stream()

                // Take While operation artinya "Ambil Selama" kondisinya true
                // selama data stream memenuhi kondisi yang ditentukan maka diambil
                // Tapi, saat menemui kondisi False, maka akan selesai (tidak lagi mengambil data)
                // meskipun masih ada data selanjutnya yang memenuhi kondisi tetap tidak diambil
                // karena sekali sudah menemui False, maka sudah berhenti
                // misalnya kita ambil data dengan kondisi length <= 4
                .takeWhile(name -> name.length() <= 4)

                // jalankan streamnya
                .forEach(System.out::println);
    }

    @Test
    @Order(4)
    @DisplayName("Membuat DropWhile (Hapus Selama) operation data stream")
    void testDropWhile() {

        // drop artinya ignore atau lupakan selama kondisinya true
        // jika menemukan data dengan kondisinya false, otomatis semua data sampai kebelakang akan diambil

        List.of("Ohm", "Albert", "Faraday", "Newton", "Tesla", "Gosling")

                // convert to stream
                .stream()

                // DropWhile operation artinya "Hapus Selama" kondisinya true
                // selama data stream memenuhi kondisi, maka data akan dihapus (kebalikan dari TakeWhile)
                // jadi data stream akan di ignore selama kondisinya true
                // sampai menemui data yang kondisinya False, maka data stream akan diambil atau ditampilkan semua
                // data stream diambil sampai habis, meskipun data selanjutnya terdapat yang true lagi
                .dropWhile(name -> name.length() <= 6 )

                // jalankan stream nya
                .forEach(System.out::println);
    }

    // KESIMPULAN:
    // Jika ingin ambil datanya SEBAGIAN, maka gunakan Retrieving
    // Jika ingin ambil datanya DICEK SATU PERSATU terlebih dahulu, maka gunakan Filtering
}
