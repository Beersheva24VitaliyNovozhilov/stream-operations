package io.p4r53c.telran.stream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class StreamTasksTest {

    private int[] array = { 1, 2, 3, 4, 5 };

    @Test
    void testShuffle() {
        int[] shuffled = StreamTasks.shuffle(array);
        assertNotEquals(array, shuffled);
    }

    @Test
    void testShuffleArrayLength() {
        int[] shuffled = StreamTasks.shuffle(array);
        assertEquals(array.length, shuffled.length);
    }

    // Verifies that every element in the shuffled array is present in the original
    // array.
    @Test
    void testShuffleVerifyElements() {
        int[] shuffled = StreamTasks.shuffle(array);
        assertTrue(Arrays.stream(shuffled).allMatch(x -> Arrays.stream(array).anyMatch(y -> y == x)));
    }

    @Test
    void testShuffleNoDuplicates() {
        int[] shuffled = StreamTasks.shuffle(array);
        assertEquals(array.length, Arrays.stream(shuffled).distinct().count());
    }

    @Test
    void testShuffleMultipleCalls() {
        int[] shuffled1 = StreamTasks.shuffle(array);
        int[] shuffled2 = StreamTasks.shuffle(array);
        assertNotEquals(shuffled1, shuffled2);
    }

    @Test
    void testShuffleEmptyArray() {
        int[] emptyArray = {};
        int[] shuffled = StreamTasks.shuffle(emptyArray);
        assertEquals(emptyArray.length, shuffled.length);
    }

    @Test
    void testShuffleSingleElementArray() {
        int[] singleElementArray = { 1 };
        int[] shuffled = StreamTasks.shuffle(singleElementArray);
        assertEquals(singleElementArray.length, shuffled.length);
        assertEquals(singleElementArray[0], shuffled[0]);
    }
}