import ZohoChatGPT.DSStack;


//write a program to find the character which has most occurrence in a given string.Priority should be given to the first most occurrence characcter when two characters have the same numbers of occurrences.
//
//Example:
//Input : occurrence
//Output : c , 3 times
//
//input : mississippi
//output : s , 4 times(since char 's' is the first char which occurs 4 times)
//
//Input : onechar
//output : o , 1 time

import java.util.Scanner;

public class MostOccurrence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mainstr = scanner.nextLine();

        char mostFrequentChar = findFirstMostFrequentChar(mainstr);
        System.out.println("the ans is  "+mostFrequentChar);
    }

    public static char findFirstMostFrequentChar(String str){
        if(str == null || str.isEmpty()){
            return '\0';
        }
        int[] charCount = new int[256];
        char required = str.charAt(0);

        for(int i = 0;i< str.length();i++){
            char currentChar = str.charAt(i);
            System.out.println(currentChar + " : currentchar");
            int ccIndex = (int)currentChar;
            System.out.println(ccIndex +" : ccIndex ");
            charCount[ccIndex]++;
            System.out.print(charCount[ccIndex]+" :charcount[ccIndex]++ ");
            System.out.println(charCount[required] +" : charCount[required]");
            System.out.println("\n");
            if(charCount[ccIndex] > charCount[required]){
                required = currentChar;
            }
        }

        return required;
    }
}
