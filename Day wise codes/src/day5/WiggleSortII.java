package day5;

import java.util.Collections;
import java.util.PriorityQueue;

public class WiggleSortII {
    public static void main(String[] args) {

    }

    public static void wiggleSort(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++)
            pq.offer(arr[i]);

        for (int i = 1; i < arr.length; i = i + 2)
            arr[i] = pq.poll();

        for (int i = 0; i < arr.length; i = i + 2)
            arr[i] = pq.poll();
    }
}
