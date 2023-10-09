import java.util.Locale;
import java.util.Scanner;

public class RemovePalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strarr = str.split(" ");

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strarr.length;i++){
            boolean fin = checkpalindrome(strarr[i]);

            if(fin == true){
                //System.out.println("");
            }
            else if (fin == false){
                sb.append(strarr[i]);
                sb.append(" ");
            }
        }
        System.out.println(sb);

    }
    public static boolean checkpalindrome(String str){
        char[] chararray = new char[str.length()];
        str = str.toLowerCase();
        for(int i=0;i<str.length();i++){
            chararray[i] = str.charAt(i);

        }
        char[] revarray = new char[str.length()];

        int n = str.length()-1;
        for(int i=0;i<str.length();i++){
            revarray[i] = chararray[n];
            n--;
        }


        int z =0;
        for(int i=0;i<str.length();i++){
            if(chararray[i] == revarray[i]){
                z++;
            }
        }
        if(z!=str.length()){
            return false;
        }
        return true;
    }
}
