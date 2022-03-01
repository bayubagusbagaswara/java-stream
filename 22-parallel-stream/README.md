# Parallel Stream

- Salah salah satu fitur menarik di Java Stream adalah Stream bisa dijalankan secara parallel 
- Secara garis besar, parallel artinya beberapa proses berjalan secara bersamaan 
- Secara default, Parallel Stream akan dijalankan di `ForkJoinPool` 
- dimana akan di running secara default menggunakan Thread sejumlah maksimal total CPU kita