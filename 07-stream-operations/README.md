# Stream Operations

- Stream Operations adalah `kumpulan operasi-operasi` yang bisa kita gunakan `untuk memanipulasi Stream` itu sendiri
- Secara garis besar, Stream Operations tidak akan memodifikasi data aslinya
- melainkan hasil dari Stream Operations adalah `sebuah Stream baru`
- Jadi jika kita punya sebuah data stream, kemudian kita melakukan operation terhadap stream tersebut, maka si operation akan membuatkan stream baru yang sama dengan stream awal
- Dan stream itulah yang nantinya akan melalui proses operation

# Operations Map

- Jika kita ingin memanipulasi data stream nya 
- kita bisa menggunakan function map 
- karena map() fungsinya adalah mengubah dari satu bentuk object menjadi bentuk object yang lain
