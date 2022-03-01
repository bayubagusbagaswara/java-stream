# Primitive Stream

- Sebelumnya kita sudah tahu bahwa implementasi Stream di Java adalah java.util.stream.Stream<T>
- Namun bagaimana jika kita butuh melakukan stream terhadap data primitive seperti int, long, atau double?
- Karena untuk Generic hanya bisa menampung tipe data Object, maka di Java Stream, dibuat implementasi Stream khusus untuk tipe data primitive

# Primitive Stream Class

- `java.util.stream.IntStream` : Stream untuk tipe data int
- `java.util.stream.LongStream` : Stream untuk tipe data long
- `java.util.stream.DoubleStream` : Stream untuk tipe data double