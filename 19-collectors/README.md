# Collect Operation

- Stream memiliki sebuah operator bernama collect (Collector)
- function collect biasanya digunakan untuk meng-collect (atau mengambil data didalam streamnya) data Stream 
- dan kita ubah menjadi struktur data yang kita inginkan 
- biasanya kebanyakan developer menggunakan operator collect() untuk mengubah Stream menjadi Collection 
- operator collect() membutuhkan parameter Collector, namun biasanya kita jarang sekali membuat implementasi interface Collector, karena terlalu kompleks 
- untungnya java stream sudah menyediakan sebuah class Helper untuk membuat Collector, bernama Collectors

# Collectors

- Collectors adalah class helper yang bisa digunakan untuk membuat Collector 
- ini mempermudah kita ketika ingin melakukan operasi collect terhadap sebuah Stream 
- ada banyak sekali static method yang terdapat di class Collectors

# Membuat Map dengan Collectors

- selain Collection, Collectors juga bisa digunakan untuk membuat Map dari Stream 
- yang membedakan dengan List atau Set kita harus tentukan function untuk membentuk Key dan Value nya jika ingin membuat Map 
- Ada banyak function yang bisa kita gunakan, seperti `Collectors.toMap()`, `Collectors.toConcurrentMap()` dan `Collectors.toUnmodifiable()`
