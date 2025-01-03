package day2;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {
    public static void main(String[] args) {
        BullsAndCows obj = new BullsAndCows();
        System.out.println(obj.getHint("1807", "7810"));
    }

    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : secret.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) - 1);
            } else if (map.getOrDefault(guess.charAt(i),0) > 0) {
                cows++;
                map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) - 1);
            }
        }

        return bulls + "A" + cows + "B";
    }
}
