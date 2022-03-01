# Partitioning By

- Selain grouping by, Collectors juga bisa digunakan untuk partitioning by
- Hanya saja hasil dari partitioning by hanyalah 2 buah group boolean (true, false)
- Hal ini berarti partitioning by hanya akan menghasilkan Map<Boolean, List<Value>>