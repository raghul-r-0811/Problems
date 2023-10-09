package ZohoChatGPT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramGenerator {
    public static List<String> generateAnagrams(String str) {
        if (str.isEmpty()) {
            return new ArrayList<>(Arrays.asList(""));
        }

        List<String> anagrams = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String remainingStr = str.substring(0, i) + str.substring(i + 1);
            List<String> smallerAnagrams = generateAnagrams(remainingStr);
            for (String smallerAnagram : smallerAnagrams) {
                anagrams.add(ch + smallerAnagram);
            }
        }

        return anagrams;
    }

    public static void main(String[] args) {
        String str = "";
        List<String> anagrams = generateAnagrams(str);
        for (String anagram : anagrams) {
            System.out.println(anagram);
        }
    }
}
