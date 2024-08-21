package io.github.flmaria.java_017.enhancedpseudorandomnumbergenerators;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class Main {

    public static void main(String[] args) {
        // Create a random generator using the L64X128MixRandom algorithm
        RandomGenerator rng = RandomGeneratorFactory.of("L64X128MixRandom").create();

        // Generate a stream of random doubles and print them
        rng.doubles(10).forEach(System.out::println);

        // Generate a random integer
        int randomInt = rng.nextInt();
        System.out.println("Random Integer: " + randomInt);

        // Generate a random long
        long randomLong = rng.nextLong();
        System.out.println("Random Long: " + randomLong);

        // Generate a random double
        double randomDouble = rng.nextDouble();
        System.out.println("Random Double: " + randomDouble);
    }

}
