package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
public class TestRestController {

    @GetMapping("/test1")
    public String test1() {
        log.info("called test1");
        return "Hello, World 1!";
    }

    @GetMapping("/test2")
    public String test2() {
        log.info("called test2");
        return "Hello, World 2!";
    }

    @GetMapping("/test3")
    public void test3() {
        log.info("called test3");
        for (int i = 0; i < 10_000; i++) {
            UUID uuid = UUID.randomUUID();
            log.info("uuid: {}", uuid);
        }
    }

    // Method to generate a large Fibonacci sequence
    public static List<Long> generateFibonacci(int n) {
        List<Long> fibSequence = new ArrayList<>();

        // Initialize the first two Fibonacci numbers
        if (n > 0) fibSequence.add(0L);
        if (n > 1) fibSequence.add(1L);

        // Generate Fibonacci numbers and store in the list
        for (int i = 2; i < n; i++) {
            long fib = fibSequence.get(i - 1) + fibSequence.get(i - 2);
            fibSequence.add(fib);
        }

        return fibSequence;
    }

    // A memory-intensive recursive method that stores Fibonacci sequences
    private void memoryIntensiveTask(int n, int depth) {
        if (depth == 0) return;

        // Generate Fibonacci sequence of size 'n'
        List<Long> fibSequence = generateFibonacci(n);

        // Output current depth and size of Fibonacci sequence
        System.out.println("Depth: " + depth + ", Fibonacci Sequence size: " + fibSequence.size());

        // Recur with reduced depth
        memoryIntensiveTask(n, depth - 1);
    }

    @GetMapping("/test4")
    public void test4() {
        log.info("called test4");
        memoryIntensiveTask(100_000, 1_000);
    }

    // Method to check if a number is prime
    public static boolean isPrime(long number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        for (long i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) return false;
        }

        return true;
    }

    // CPU-intensive method to calculate prime numbers up to 'n'
    public static void calculatePrimes(long n) {
        long primeCount = 0;

        for (long i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primeCount++;
            }
        }

        System.out.println("Total prime numbers up to " + n + ": " + primeCount);
    }

    @GetMapping("/test5")
    public void test5() {
        log.info("called test5");
        calculatePrimes(1_000_000L);
    }

}
