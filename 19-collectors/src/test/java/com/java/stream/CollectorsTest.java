package com.java.stream;

import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@DisplayName("Test Collectors")
public class CollectorsTest {

    // method getStream adalah method yang mengembalikan data Stream

    Stream<String> getStream(){
        return Stream.of("Albert", "Faraday", "Tesla", "Newton", "Ohm");
    }

    @Test
    @Order(1)
    @DisplayName("Konversi dari Stream menjadi Collection")
    void testCollection() {

        // kita akan melakukan konversi dari sebuah data Stream menjadi data Collection
        // misal kita konveri data stream dari method getStream menjadi sebuah data Set milik Collection

        // Pertama, kita collect dulu data di streamnya
        // setelah itu baru bisa dikonversi menjadi Set menggunakan toSet milik Collectors
        // balikan datanya sudah berupa Set of String

        Set<String> set = getStream().collect(Collectors.toSet());
        set.remove("Ohm"); // menghapus data di set
        System.out.println("Data Set: " + set);

        // bisa juga dikonversi menjadi Set yang Immutable
        // artinya Set nya sudah tidak bisa diubah-ubah lagi, tidak bisa bisa ditambah atau dihapus

        Set<String> immutableSet = getStream().collect(Collectors.toUnmodifiableSet());

        // immutableSet.add("Michael"); // error, tidak bisa menambahkan data ke set nya
        // immutableSet.remove("Issac"); // error, tidak bisa menghapus data di set nya

        System.out.println("Data Immutable Set: " + immutableSet);
        immutableSet.forEach(new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println("Name : " + name);
            }
        });

        // bisa juga konversi dari Stream menjadi List
        // balikannya sudah List of String

        List<String> list = getStream().collect(Collectors.toList());

        // remove data di list nya berdasarkan index
        list.remove(1);
        System.out.println("Data List: " + list);

        // konversi menjadi List Immutable
        List<String> immutableList = getStream().collect(Collectors.toUnmodifiableList());
        System.out.println("Data Immutable List: " + immutableList);
    }


    @Test
    @Order(2)
    @DisplayName("Konversi dari Stream menjadi Map dengan Key dan Value")
    void testMap() {

        // jika konversi menjadi Map
        // perhatikan Key dan Valuenya
        // tentukan mana Key dan mana Valuenya

        Map<String, Integer> dataMap = getStream().collect(Collectors.toMap(
                // misal Key nya adalah nama dari data List
                // Value nya adalah panjang dari nama
                // dipisahkan dengan koma
                name -> {
                    return name;
                }, String::length
        ));

        // ambil data dari Map nya
        // menggunakan method static forEach atau bisa perulangan forEach

        System.out.println("CARA 1");
        dataMap.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String name, Integer lengthName) {
                System.out.println("Name : " + name + ", Length : " + lengthName);
            }
        });

        System.out.println("CARA 2");
        for (var map: dataMap.entrySet()) {
            System.out.println("Name: " + map.getKey() + ", Length: " + map.getValue());
        }
    }
}
