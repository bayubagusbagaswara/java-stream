package com.java.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class SingleStreamTest {

    @Test
    @DisplayName("Create Stream for Single Data")
    void testCreateEmptyOrSingleStream() {

        Stream<String> stream1 = Stream.of("Albert Einstein");

        // ofNullable bisa ada datanya atau null
        Stream<String> stream2 = Stream.ofNullable(null);

        Stream<String> stream3 = Stream.empty();
    }
}
