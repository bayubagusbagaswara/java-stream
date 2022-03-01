# Aggregate Operations

- Java Stream mendukung banyak operasi untuk melakukan proses `aggregate`
- Seperti menghitung jumlah data, menghitung `data maximum` dan menghitung `data minimum`

# Method Aggregate Operations

- `max(Comparator)` berfungsi untuk mencari data max sesuai comparator
- `min(Comparator)` berfungsi untuk mencari data min sesuai comparator
- `count()` berfungsi untuk menghitung total data

# Manual Aggregate Menggunakan Reduce

- Java Stream juga menyediakan sebuah operasi yang bernama reduce
- Reduce bisa digunakan untuk melakukan proses aggregate secara manual
- Misal kita ingin menjumlahkan seluruh angka yang terdapat di Stream, kita bisa melakukan ini menggunakan reduce operator
- Di bahasa pemrograman lain, reduce mirip seperti operasi `fold`

# Catatan

- java stream juga mendukung banyak operasi untuk melakukan proses aggregate 
- seperti menghitung jumlah data, menghitung data maximum dan menghitung data minimum 
- aggregate operation termasuk terminal operations, artinya dia juga otomatis mengeksekusi stream nya 
- aggregate itu tidak membuat stream baru, artinya dia terminal operations 
- balikan data dari operation Aggregate adalah Optional 
- Optional sendiri adalah turunan dari Stream, jadi sama saja membuat Stream baru, makanya disebut terminal operation