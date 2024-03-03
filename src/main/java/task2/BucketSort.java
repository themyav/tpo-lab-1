package task2;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public static ArrayList<Integer> bucketSort(ArrayList<Integer>list) {
        if (list.isEmpty()) {
            return list;
        }

        int bucketSize = list.size();
        int minValue = Collections.min(list);
        int maxValue = Collections.max(list);

        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        ArrayList<ArrayList<Integer>>buckets = new ArrayList<>(bucketCount);

        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int value : list) {
            int bucketIndex = (value - minValue) / bucketSize;
            buckets.get(bucketIndex).add(value);
        }

        list.clear();
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
            list.addAll(bucket);
        }

        return list;
    }
}
