package task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class BucketSortTest {

    @Test
    void testBucketSortEmptyList() {
        ArrayList<Integer> input = new ArrayList<>();
        assertEquals(getSorted(input), BucketSort.bucketSort(input));
    }

    @Test
    void testBucketSortSingleElement() {
        ArrayList<Integer> input = new ArrayList<>(Collections.singletonList(5));
        assertEquals(getSorted(input), BucketSort.bucketSort(input));
    }

    @Test
    void testBucketSortMultipleElements() {
        ArrayList<Integer> input = new ArrayList<>();
        for(int i = 0; i < 1000; i++) input.add(i);
        Collections.shuffle(input);
        assertEquals(getSorted(input), BucketSort.bucketSort(input));
    }

    @Test
    void testBucketSortDuplicateElements() {
        ArrayList<Integer> input = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 1000; i++) input.add(random.nextInt(1000));
        assertEquals(getSorted(input), BucketSort.bucketSort(input));
    }

    @Test
    void testBucketSortIdenticalElements() {
        ArrayList<Integer> input = new ArrayList<>();
        for(int i = 0; i < 1000; i++) input.add(3);
        assertEquals(getSorted(input), BucketSort.bucketSort(input));
    }

    ArrayList<Integer>getSorted(ArrayList<Integer>input){
        ArrayList<Integer> sorted = new ArrayList<>(input);
        Collections.sort(sorted);
        return sorted;
    }


}
