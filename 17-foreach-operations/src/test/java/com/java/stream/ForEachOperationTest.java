package com.java.stream;

import org.junit.jupiter.api.*;

import java.util.List;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@DisplayName("Test ForEach Operation")
public class ForEachOperationTest {

    // Peek akan mengembalikan data stream aslinya
    // forEach itu return value nya adalah void, artinya dia menjadi terminal operation

    @Test
    @Order(1)
    @DisplayName("Membuat operation tanpa Peek")
    void testPeekBefore() {
        // kadang kita ingin melakukan iterasi terhadap datanya
        // tapi tanpa harus menggunakan terminal operation, seperti forEach langsung dieksekusi streamnya
        // misal kita buat stream tanpa peek

        List.of("Albert", "Tesla", "Gosling", "Faraday", "Newton")
                .stream()
                .map(name -> {
                    System.out.println("Before Change Name to Upper " + name);
                    String upper = name.toUpperCase();
                    System.out.println("Change Name to Upper : " + upper);
                    return upper;
                })
                .forEach(name -> System.out.println("Final Name : " + name))
        ;

        // dari kode program diatas sebenarnya kita hanya melakukan map
        // dan ingin memastikan datanya berhasil di map atau tidak
        // dan itu sangat kepanjangan program di map nya
    }

    @Test
    @Order(2)
    @DisplayName("Membuat operation dengan menambahkan Peek")
    void testPeekAfter() {
        // peek itu melakukan iterasi satu persatu data di Stream
        // namun mengembalikan Stream lagi, jadi dibalikin stream aslinya
        // dan ini bukanlah terminal operation, jadi tidak akan langsung ditrigger streamnya
        // di operation map sudah tidak perlu membuat kode program yang panjang

        List.of("Albert", "Tesla", "Gosling", "Faraday", "Newton")
                .stream()
                .peek(name -> {
                    System.out.println("Before Change Name to Upper: " + name);
                })
                .map(String::toUpperCase)
                .peek(upper -> {

                    // peek ini akan mengembalikan data stream UPPER
                    // padahal setelah di map juga sudah berubah jadi UPPER
                    // hanya saja di peek data UPPER tersebut akan di iterasi satu persatu dan ditambahkan string yang kita tentukan
                    // kemudian dibalikkan lagi data streamnya
                    // peek juga berfungsi untuk memastikan apakah benar data stream hasil map benar-benar berubah datanya

                    System.out.println("Change Name to Upper: " + upper);
                })
                .forEach(name -> System.out.println("Final Name : " + name))
        ;

        // dengan menambahkan peek ini, maka bisa lebih enak dalam membaca data di streamnya
    }
}
