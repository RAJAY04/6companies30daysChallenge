package day28;

import java.util.HashMap;
import java.util.Random;

public class RandomFlipMatrix {
    public static void main(String[] args) {
        RandomFlipMatrix obj = new RandomFlipMatrix(2, 3);
    }

    HashMap<Integer, Integer> map;
    int row;
    int col;
    Random ran;
    int total;

    RandomFlipMatrix(int m, int n) {
        map = new HashMap<>();
        ran = new Random();
        row = m;
        col = n;
        total = row * col;
    }

    public int[] flip() {
        int r = ran.nextInt(total);
        int x = map.getOrDefault(r, r);
        total--;
        map.put(r, map.getOrDefault(total, total));

        return new int[] { x / col, x % col };
    }

    public void reset() {
        map.clear();
        total = row * col;
    }
}
