# Retrieving Operations

- Retrieving Operations adalah operasi pada Stream untuk melakukan pengambilan `sebagian data`
- Secara garis besar, cara kerja nya hampir mirip dengan Filtering

# Method Retrieving Operations

- `limit(n)` berfungsi untuk mengambil sejumlah n data
- `skip(n)` berfungsi untuk menghiraukan sejumlah n data
- `takeWhile(T -> Boolean)` untuk mengambil data selama kondisi true
- `dropWhile(T -> Boolean)` untuk menghiraukan data selama kondisi true