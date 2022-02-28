# 9th Path Learning Java : Java Stream

# Tools

- Java JDK 17
- Create project with spring.io

# Agenda

- Pengenalan Java Stream
- Membuat Stream
- Lazy Evaluation
- Stream Builder
- Stream Operations
- Collectors
- Parallel Stream

# Pengenalan Java Stream

- Java Stream diperkenalkan pertama kali di Java versi 8 atau 1.8
- Java Stream adalah implementasi di Java untuk `aliran data`
- Java Stream erat kaitannya dengan Java Collection dan Lambda Expression
- Semua fitur Java Stream terdapat di package java.util.stream

# Apa itu Stream?

- Stream adalah `aliran data`
- Berbeda dengan Array atau Collection yang merupakan kumpulan data
- Biasanya dalam Array atau Collection, kita selalu fokus terhadap data.
- Sedangkan dalam Stream, kita akan fokus terhadap operasi apa yang akan kita lakukan

# Class java.util.stream.Stream<T>

- Java Stream diimplementasikan oleh sebuah class bernama Stream di dalam package java.util.stream
- Java Stream tidak sekompleks Java Collection. Namun walaupun sederhana, fitur Java Stream sangat powerfull
- Class Stream merupakan Generic Class, sehingga kita bisa membuat aliran data dengan tipe yang kita inginkan
