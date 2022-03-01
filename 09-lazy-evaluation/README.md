# Lazy Evaluation

- Stream secara default adalah lazy
- Dia tidak akan mengalirkan data jika belum menggunakan terminal operation
- Selain itu, data hanya akan dialirkan seperlunya saja, tergantung terminal operation nya

# Intermediate & Terminal Operations

- Secara garis besar ada 2 jenis stream operations, yakni `Intermediate` & `Terminal Operations`
- `Intermediate Operations` merupakan `lazy operation`, dimana Stream tidak akan dieksekusi sampai memang dibutuhkan (atau perlu ditrigger dahulu)
- Sedangkan `Terminal Operations` merupakan operasi yang `men-trigger` sebuah Stream berjalan
- Karena Intermediate Operations adalah lazy, maka secara garis besar, semua Intermediate Operations akan `mengembalikan Stream lagi`
- Kalau return nya adalah stream lagi, berarti dia tidak akan dieksekusi atau streamnya tidak dijalankan
- Jika return nya bukan stream, misal void atau int, maka dia adalah Terminal Operations atau dia mampu menjalankan sebuah stream