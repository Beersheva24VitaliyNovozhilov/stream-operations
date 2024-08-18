package io.p4r53c.telran.stream;

import java.util.Arrays;
import java.util.Random;

public class StreamTasks {

    private static final Random random = new Random();

    private StreamTasks() {
    }

    /**
     * Shuffles the elements of the given integer array.
     * 
     * It seems that there is a several ways to do this.
     * 
     * 1. {@link java.util.Collections#shuffle(java.util.List)} method
     * 
     * 2. {@link java.util.stream.Stream#sorted(java.util.function.Function)} method
     * 
     * 3. Even thread-safe {@link java.util.concurrent.ThreadLocalRandom} method
     * 
     * {@link java.util.Collections#shuffle()} uses a similar approach
     * under the hood using {@link java.util.Random#nextInt()}.
     * Explicitly using {@link java.util.Collections#shuffle()} is
     * probably a bit of a cheat for this task, so I decided to do an explicit
     * random sort. In my opinion, this code is shorter and clearer.
     * 
     *
     * @param array the array of integers to be shuffled
     * @return the shuffled array of integers
     */
    public static int[] shuffle(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .sorted((a, b) -> random.nextInt(3) - 1)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
