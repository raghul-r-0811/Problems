import java.util.Scanner;

public class CheckSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter first string");
        String mainstr = scanner.nextLine();
        System.out.println("enter first string");
        String substr = scanner.nextLine();
        boolean flag = checksub(mainstr,substr);
        if(flag){
            System.out.println(flag);
        }else{
            System.out.println(YorNsubstring(mainstr,substr));
        }

    }
    public static boolean YorNsubstring(String mainstr,String substr){

       int i=0;
       int j=0;
       boolean starFlag = false;
       while(mainstr.charAt(i) == substr.charAt(j)  && i< mainstr.length() && !starFlag){
           if (substr.charAt(j) == '*') {
               starFlag = true;
               continue;
           }// checking if the first character in the substring is '*'

           i++;
           j++;
           if(i == mainstr.length()){
               System.out.println("here false 1");
               return false;
           }
       }

        if(mainstr.charAt(i+1) == '*' && substr.charAt(j+1) == '\\' & substr.charAt(j+2) == '*'){
            i++;
            j+=2;
        } else if (mainstr.charAt(i + 1) == '*' && substr.charAt(j + 1) == '\\' & substr.charAt(j + 2) != '*') {
            return false;
        }


        while(substr.charAt(j) == '*' && j<substr.length() && j+1 <substr.length()){

           if(substr.charAt(j+1) != '*' && substr.charAt(j+1) != mainstr.charAt(i+1)){
               if(substr.charAt(j+1) == mainstr.charAt(i)){
                   i--;
                   j++;
               }
               System.out.println("here false 2");
               i++;
           }else if(substr.charAt(j+1) != '*' && substr.charAt(j+1) == mainstr.charAt(i+1)){

               i++;
               j++;
           }else{
               j++;
           }
       }   String newMain = stringCutter(mainstr,i);
        String newSub = stringCutter(substr,j);

        return checksub(newMain,newSub);
    }

    public static boolean checksub(String mainStr, String substr){
        for(int i=0;i<=mainStr.length()-substr.length();i++){
            boolean found = true;
            for(int j=0;j<substr.length();j++){
                if(substr.charAt(j)== '*'){
                    return YorNsubstring(mainStr,substr);
                }
                if(mainStr.charAt(i+j)!=substr.charAt(j)){
                    found = false;
                    break;
                }
            }
            if(found){
                return true;
            }
        }
        return false;
    }

    public static String stringCutter(String str,int index){
        if(index == 0){
            return str;
        }
        StringBuilder newString = new StringBuilder();

        for(int i = index;i<str.length();i++){
            newString.append(str.charAt(i));
        }
        return newString.toString();
    }
}
// this while loop move i to the position where the character in the main string matches the first letter of the substring.If nothing ,matches it is not a substring
// while loop exits if the first character of substring is '*'


// this while loop moves the string until the substring has no stars next after the end and check if there is letters between the stars and


// System.out.println("the newMain is  : "+newMain);
//         System.out.println("the newsub is  : "+newSub);
//
//         System.out.println("true or false from cchecksub");

// System.out.println("entering second while loop");
//         System.out.println("here i is : " +i);
//         System.out.println("here j is : " +j);