import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindLongestPalindrome {




    public static void main(String[] args) {
        String input = "This is a sample text for testing";
        input = removeSpaces(input);
        System.out.println(input);
        String maxPalindrome = findMaxPalindrome(input);
        System.out.println("The length is "+maxPalindrome.length()+" the palindrome is  "+maxPalindrome);

    }

    public static String removeSpaces(String str){
        String[] retstr = str.split(" ");
        String mainstr = "";
        for(int i = 0;i< retstr.length;i++){
            mainstr +=retstr[i].toLowerCase();
        }
        return mainstr;
    }

    public static String findMaxPalindrome(String str){

        int frquency[] = findFrequencyArr(str);
        String maxPalindrome = buildPalindrome(frquency);

        return maxPalindrome;
    }
    //a-2
    //d-3
    //i-3
    //s-4
    //t-5
    public static int[] findFrequencyArr(String str){
        int freqArr[] = new int[27];
        for(int i = 0;i<str.length();i++){
            char arrCh = str.charAt(i);
            freqArr[(int)arrCh - 97]++;
        }
        return freqArr;
    }

    public static String buildPalindrome(int[] freq){
        String builderStr ="";
        for(int i=0;i< freq.length;i++){
            if(freq[i]/2 != 0){
                for(int j=0;j<freq[i]/2;j++){
                    builderStr +=(char)(i+97);;
                }
            }
        }
        System.out.println("before adding rev "+ builderStr);
        char revArr[]= new char[builderStr.length()];
        int j=0;
        for(int i = builderStr.length()-1;i>=0;i--){
            revArr[j++] = builderStr.charAt(i);
        }

        String revStr = charArrToStr(revArr);
        System.out.println("revStr"+revStr);

        for(int i=0;i< freq.length;i++){
            if(freq[i]%2 == 1){
                builderStr += (char)(i+97);
                break;
            }
        }
        System.out.println("after adding mid "+ builderStr);
        builderStr += revStr;
        System.out.println("after adding revStr "+ builderStr);
        return builderStr;
    }
    public static String charArrToStr(char[] rev){
        String retStr = "";
        for(int i =0;i<rev.length;i++){
            retStr += rev[i];
        }
        return retStr;
    }
}
