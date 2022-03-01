# Stream Builder

- Kadang kita ingin membuat Stream secara manual, seperti menambah datanya ke Stream secara manual
- Java menyediakan Stream Builder untuk membuat Stream secara manual
- dan kita bisa menggunakannya seperti Collection
- kita bisa membuat Stream Builder, menambahkan data ke Stream Builder
- setelah selesai baru kita buat Streamnya

# Catatan

- setelah data-datanya berhasil masuk semua ke stream builder
- maka kita konversi builder tersebut menjadi stream
- cara menambahkan data ke stream builder memiliki 2 method, yakni `accept()` dan `add()`
- `accept()` memiliki return void
- `add()` return nya adalah builder itu sendiri (bisa di chaining method add nya)
- untuk mengkonversi dari builder menjadi stream pake method `build()`