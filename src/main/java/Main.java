import task1.AtanTailorSummator;
import task2.BucketSort;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        double res = AtanTailorSummator.getSum(1, 5);
        System.out.println(res);


        ArrayList<Integer> myList = new ArrayList<>();
        for(int i = 9; i >= 0; i--) myList.add(i);
        for(int i = 9; i >= 0; i--) myList.add(2 * (i % 2));
        System.out.println(myList);
        System.out.println(BucketSort.bucketSort(myList));

    }
}
