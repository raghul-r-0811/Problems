import java.util.*;
public class Experiments {
    public static void main(String[] args) {
        String text = "This is a Sample text for testing";
        text = concateString(text);
        int[] charCount = new int[26];
        for(int i =0;i<text.length();i++){
            int num = text.charAt(i) - 97;
            charCount[num]++;
        }

        String longestPalindrome = "";
        int maxLen = 0;
        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j <= text.length(); j++) {
                String substring = text.substring(i, j);
                boolean isPalindrome = true;
                int oddCount = 0;
                for (int k = 0; k < substring.length(); k++) {
                    int c = substring.charAt(k) - 'a';
                    int index = Math.min(c, 25);
                    if (charCount[index] % 2 == 1) {
                        oddCount++;
                    } else {
                        oddCount--;
                    }
                    if (oddCount > 1) {
                        isPalindrome = false;
                        break;
                    }
                }
                if (isPalindrome && substring.length() > maxLen) {
                    maxLen = substring.length();
                    longestPalindrome = substring;
                }
            }
        }

        System.out.println("Max possible palindrome: " + longestPalindrome.length() + " characters");
        System.out.println(longestPalindrome);
    }
    public static String concateString(String inputString){
        StringBuilder concatenated = new StringBuilder();
        String[] strArr =  inputString.split(" ");
        for(int i =0;i<strArr.length;i++){
            concatenated.append(strArr[i]);
        }

        return concatenated.toString().toLowerCase();
    }
}
