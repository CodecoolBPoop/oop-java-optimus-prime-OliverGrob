package com.codecool;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    private static final List<Integer> primes = new ArrayList<>(1000);

    public static List<Integer> read(int numberTo) throws IOException {
        return Files.lines(Paths.get("resources/primes.txt"))
                    .filter(string -> Integer.parseInt(string) < numberTo)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
    }

    @Test
    void testCalculatePrimesInvalidInput() {
        assertAll("Testing if the input is invalid:",
                () -> System.out.println("Testing if the input is invalid:\nInput parameter is 1"),
                () -> assertNull(Main.calculatePrimes(1)),
                () -> System.out.println("Input parameter is 0"),
                () -> assertNull(Main.calculatePrimes(0)),
                () -> System.out.println("Input parameter is -3122"),
                () -> assertNull(Main.calculatePrimes(-3122)),
                () -> System.out.println("All input tests passed!\n"));
    }

    @Test
    void testCalculatePrimesActualValues() throws IOException {
        assertAll("Testing with actual values:",
                () -> System.out.println("Testing with actual values:\nInput parameter is 100"),
                () -> assertEquals(PrimeTest.read(100), Main.calculatePrimes(100)),
                () -> System.out.println("Input parameter is 2345"),
                () -> assertEquals(PrimeTest.read(2345), Main.calculatePrimes(2345)),
                () -> System.out.println("Input parameter is 7400"),
                () -> assertEquals(PrimeTest.read(7400), Main.calculatePrimes(7400)),
                () -> System.out.println("All tests with actual values passed!\n"));
    }

}