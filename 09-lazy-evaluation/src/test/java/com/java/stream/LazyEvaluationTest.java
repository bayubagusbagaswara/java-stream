package com.java.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class LazyEvaluationTest {

    // Stream secara default adalah lazy
    // dia tidak akan mengalirkan data jika belum menggunakan terminal operation
    // terminal operation adalah sebuah operasi yang mentrigger sebuah stream untuk mengalirkan datanya
    // selain itu, data hanya akan dialirkan seperlunya saja, tergantung terminal operationnya

    @Test
    @DisplayName("Intermediate Operation")
    void testIntermediateOperation() {

        // contohnya adalah operation map, karena hasil dari map adalah mengembalikan data Stream lagi
        // jadi Map adalah Intermediate Operations

        // membuat sebuah data List
        List<String> names = List.of("Apple", "Orange", "Mango", "Avocado", "Cherry");

        // konversi data List menjadi Stream of String
        Stream<String> upper = names.stream()

                // kemudian lakukan operation map
                // pada perintah ini kita tahu apakah benar akan dieksekusi menjadi UPPER atau tidak, karena map adalah lazy

                // .map(name -> name.toUpperCase());

                // biasanya untuk memastikan atau mengetahui akan kebenaran operation nya, maka kita bisa tambahkan print out didalamnya
                // dan kita bisa tau data stream hasil balikan dari map

                .map(name -> {
                    System.out.println("Change " + name + " to UPPERCASE");
                    return name.toUpperCase();
                });

        // setelah kita test, kita dapatkan bahwa hasilnya kosong, tidak ada data yang keluar stream diatas
        // artinya sebanyak apapun kita menambahkan operasi intermediate
        // sebenarnya si streamnya tidak akan dieksekusi, sehingga data streamnya tidak mengalir
        // lantas bagaimana caranya untuk men-trigger agar streamnya berjalan mau mengalirkan datanya?
        // caranya adalah dengan menggunakan Terminal Operation
        // contoh dari Terminal Operation adalah forEach(), yang biasanya diletakkan diakhir sebuah perintah stream
    }

    // Agar Streamnya mengalirkan data, maka dia membutuhkan sebuah Trigger yakni Terminal Operation
    // contohnya forEach
    // jika menggunakan forEach, maka dia akan men-trigger Stream untuk mengalirkan datanya
    // pada kasus sebelumnya selalu menggunakan forEach, maka data streamnya bisa ditampilkan

    @Test
    @DisplayName("Create Stream with Terminal Operation")
    void testTerminalOperation() {

        // create data list
        List<String> names = List.of("Apple", "Orange", "Mango", "Cherry", "Avocado");

        // konversi data list menjadi data Stream of String
        names.stream()

                // masuk operation map, maka data stream akan dieksekusi satu persatu, diubah menjadi UPPER
                .map(name -> {
                    System.out.println("Change " + name + " to UPPERCASE");
                    return name.toUpperCase();
                })

                // masuk operation map selanjutnya, data streamnya sudah dalam bentuk UPPER
                // tambahkan operation untuk menambahkan string ke satu persatu data stream UPPER nya
                .map(upper -> {
                    System.out.println("Change " + upper + " to Fruit");
                    return "Fruit : " + upper;
                })

                // lalu diakhir tambahkan operation forEach
                // gunanya untuk mengeksekusi stream agar bisa berjalan
                // di forEach buat perintah untuk menampilkan data streamnya
                .forEach(mr -> {
                    System.out.println(mr);
                });

        // Ingat di Stream itu datanya mengalir satu persatu
        // tidak sekaligus ada 3 data langsung diubah menggunakan operation
        // tapi emang satu persatu tiap datanya (bergiliran sampai operation paling ujung)
        // karena sesuai dengan aliran air
        // jika satu data sudah selesai melakukan operation, maka lanjut data selanjutnya dan seterusnya
    }
}
