package ZohoChatGPT;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChatGPT_MostOccurred {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        char mostFrequentChar = findFirstMostFrequentChar(input);

        if (mostFrequentChar != '\0') {
            System.out.println(mostFrequentChar + " , " + countOccurrences(input, mostFrequentChar) + " times");
        } else {
            System.out.println("No characters found in the input.");
        }
    }

    public static char findFirstMostFrequentChar(String str) {
        if (str == null || str.isEmpty()) {
            return '\0'; // Return null character if the input is empty or null.
        }

        char mostFrequentChar = '\0'; // Initialize with a null character
        int maxCount = 0;

        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            int currentCharCount = charCount.getOrDefault(currentChar, 0) + 1;
            charCount.put(currentChar, currentCharCount);

            if (currentCharCount > maxCount || (currentCharCount == maxCount && str.indexOf(currentChar) < str.indexOf(mostFrequentChar))) {
                mostFrequentChar = currentChar;
                maxCount = currentCharCount;
            }
        }

        return mostFrequentChar;
    }

    public static int countOccurrences(String str, char target) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                count++;
            }
        }

        return count;
    }
}