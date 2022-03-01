package com.java.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class CreateStreamBuilderTest {

    // Stream Builder akan digunakan jika kita ingin memasukkan datanya dengan cara manual yakni satu persatu

    @Test
    @DisplayName("Create Stream Builder")
    void testCreateStreamBuilder() {

        // create stream builder
        Stream.Builder<String> builder = Stream.builder();

        // untuk menambahkan data ke dalam builder bisa menggunakan 2 method, yakni accept() atau add()
        // artinya data tidak dimasukkan secara bersamaan kedalam stream
        // seperti ditampung dulu oleh stream builder
        builder.accept("First Data");
        builder.add("Second Data").add("Third Data");

        // apabila mau konversi dari builder menjadi stream
        // bisa menggunakan method build() milik builder
        // balikannya sudah Stream of String, jadi isinya sudah string
        Stream<String> stream = builder.build();

        // baru bisa kita jalankan stream nya menggunakan forEach
        stream.forEach(System.out::println);
    }

    // Ada cara yang lebih simple membuat stream builder

    @Test
    @DisplayName("Create Stream builder with chaining")
    void testCreateStreamBuilderSimplify() {

        // cara buat Stream builder tapi dengan menerima balikan Stream Object
        // didalamnya kita bisa chaining method untuk menambah data, sekaligus melakukan build
        // balikannya adalah Stream of Object, karena terdiri dari banyak method yang kita chaining (tidak hanya String)
        Stream<Object> stream = Stream.builder()
                .add("Data 1")
                .add("Data 2")
                .add("Data 3")
                .add("Data 4")
                .add("Data 5")
                .build();

        // jalankan streamnya
        stream.forEach(value -> {
            System.out.println("Value: " + value);
        });
    }
}
