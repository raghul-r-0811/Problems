package ZohoChatGPT;

import java.util.Scanner;

public class GPTChekSubStr {

        public static boolean isSubstring(String mainStr, String subStr) {
            int i = 0, j = 0;
            while(i<mainStr.length() && j < subStr.length()){
                if(subStr.charAt(j)=='*'){
                    boolean escaped = false;
                    while(subStr.charAt(j) == '*' && j<subStr.length()){
                        j++;
                    }
                    while(i<mainStr.length()){
                        if(mainStr.charAt(i) == '\\'&& !escaped){
                            escaped = true;
                        }else if(mainStr.charAt(i) == subStr.charAt(j) && !escaped ){
                            if (isSubstring(mainStr.substring(i), subStr.substring(j))){
                                return true;
                            }
                        }else{
                            escaped = false;
                        }
                        i++;
                    }
                } else {
                    if(subStr.charAt(j) == '\\'){
                        if(subStr.charAt(j+1) == '*' && j+1 <subStr.length()){
                            j++;
                        }
                    }
                    if(subStr.charAt(j) != mainStr.charAt(i) && i>=subStr.length()){
                        return false;
                    }
                }
                j++;
                i++;

            }
            return j== subStr.length();
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter main string: ");
            String mainStr = scanner.nextLine();
            System.out.println("Enter substring:");
            String subStr = scanner.nextLine();
            boolean result = isSubstring(mainStr, subStr);
            System.out.println(result);
        }


}
