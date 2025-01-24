package day23;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountWordsObtainedAfterAddingALetter {
    public static void main(String[] args) {
        CountWordsObtainedAfterAddingALetter obj = new CountWordsObtainedAfterAddingALetter();
        String[] startWords = {"g","vf","ylpuk","nyf","gdj","j","fyqzg","sizec"};
        String[] targetWords = {"r","am","jg","umhjo","fov","lujy","b","uz","y"};
        System.out.println(obj.wordCount(startWords,targetWords));
    }
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> startWordMasks = new HashSet<>();

        for (String startWord : startWords)
            startWordMasks.add(mask(startWord));

        int count = 0;

        for (String targetWord : targetWords) {
            int mask = mask(targetWord);

            for (char ch : targetWord.toCharArray()) {
                if (startWordMasks.contains(mask - (1 << (ch - 'a')))) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    private int mask(String str) {
        int mask = 0;
        for (char ch : str.toCharArray())
            mask |= (1 << (ch - 'a'));
        return mask;
    }
}
