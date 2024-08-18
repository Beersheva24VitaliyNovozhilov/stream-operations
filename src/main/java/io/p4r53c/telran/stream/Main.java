package io.p4r53c.telran.stream;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new Random().ints(1, 50)
                .distinct()
                .limit(6)
                .forEach(n -> System.out.print(n + " "));
    }
}