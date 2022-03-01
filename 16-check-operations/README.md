# Check Operations

- Check Operations adalah operasi yang digunakan untuk melakukan pengecekan data di dalam Stream
- Ada banyak sekali operasi yang bisa digunakan untuk melakukan pengecekan
- Dan hasil operasi check adalah boolean 
- Check Operations ini adalah terminal operation, jadi saat kita menggunakan check operation ini maka otomatis akan dieksekusi streamnya

# Method Check Operations

- `anyMatch(T -> Boolean)` berfungsi untuk mengecek apakah ada salah satu data yang match dengan kondisi nya
- `allMatch(T -> Boolean)` berfungsi untuk mengecek apakah semua data match dengan kondisi nya
- `noneMatch(T -> Boolean)` berfungsi untuk mengecek apakah semua data tidak match dengan kondisi nya