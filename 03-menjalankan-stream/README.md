# Menjalankan Stream

- Secara default, Stream itu bersifat Cold, artinya data di Stream tidak akan mengalir sampai kita memintanya
- Ada banyak cara untuk meminta Stream mulai mengalirkan datanya. Hal ini dibahas pada bagian Stream Operations
- Untuk saat ini, salah satu method yang bisa kita gunakan agar aliran data di Stream mengalir adalah menggunakan method `forEach`
- Stream hanya bisa jalan sekali, mirip seperti aliran data, setelah mengalir, aliran data tidak bisa diulang lagi dari awal