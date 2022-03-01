# Single Stream

- Stream itu kan aliran data 
- jadi datanya bisa ada atau bisa tidak ada (data kosong)
- mirip seperti membuat Array, bisa jadi data di dalam Array tersebut kosong 
- Contoh: kita buat stream yang kosong datanya, atau minimal ada 1 data pada stream

# Method untuk Membuat Stream

Ada beberapa method di Class Stream untuk membuat sebuah Stream, seperti berikut ini:
1. method `Stream.of()` 
2. method `Stream.ofNullable()` 
3. method `Stream.empty()`

# Stream.of()

- method Stream.of() digunakan untuk memasukkan sebuah data ke stream 
- data ini harus ada, tidak boleh datanya null atau kosong, 
- jika dipaksa memasukkan data null, maka akan menyebabkan error 
- jangan sampai datanya null

# Stream.ofNullable()

- method Stream.ofNullable() digunakan untuk memasukkan sebuah data ke Stream 
- akan tetapi, method ini memperbolehkan datanya bisa diisi dengan null 
- jadi data yang dimasukkkan boleh ada ataupun data kosong 
- jika kita memasukkan data null atau kosong, secara otomatis stream akan mengetahui bahwa itu datanya kosong 
- dan kemudian stream bisa mengkonversi menjadi Stream.empty

# Stream.empty()

- method Stream.empty() yakni stream dengan data kosong atau null 
- sudah pasti di stream tidak ada datanya