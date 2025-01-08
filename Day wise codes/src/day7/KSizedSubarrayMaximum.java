package day7;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class KSizedSubarrayMaximum {
    public static void main(String[] args) {

    }
    public static ArrayList<Integer> max_of_subarrays(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0 || k <= 0) {
            return result;
        }

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        for (int i = k; i < arr.length; i++) {
            result.add(arr[deque.peekFirst()]);

            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.removeLast();
            }

            deque.addLast(i);
        }

        result.add(arr[deque.peekFirst()]);

        return result;
    }
}
