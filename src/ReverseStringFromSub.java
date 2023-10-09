import java.util.Arrays;

public class ReverseStringFromSub {
    public static void main(String[] args) {
        String mainstr = "This is a test input string";
        String sub = "st";
        int spaces = 0;
        for(int i =0 ;i<mainstr.length();i++){
            if(mainstr.charAt(i)== ' '){
                spaces++;
            }
        }

        String[] strArr = new String[spaces+1];
        int start =0;
        int end = 0;
        int index = 0;
        for(int i=0;i<mainstr.length();i++){
            if(mainstr.charAt(i) == ' ' || i == mainstr.length()-1){
                end = i;
                strArr[index] = stringCutter(start,end,mainstr);
                index++;
                start =i+1;
            }
        }
        int revStart = 0;
        boolean flag = false;
        int i =0;
        while(i<strArr.length && !flag){
            flag = checkSubstring(strArr[i],sub);
            if(flag){
                revStart = i;
            }
            i++;
        }

        revArray(strArr,revStart);
        System.out.println(Arrays.toString(strArr));
    }

    public static String stringCutter(int start,int end,String str){
        String ret = "";
        if(end == str.length()-1){
            end = str.length();
        }
        for (int i=start;i<end;i++) {
            ret += str.charAt(i) ;
        }
        return ret;
    }
    public static boolean checkSubstring(String str1,String str2){
        boolean flag = false;
        int i = 0;
        while (i <= str1.length()-str2.length()) {
            int j = 0;
            int pointer = i;
            while(j < str2.length()){
                if (str1.charAt(pointer) == str2.charAt(j)) {
                        pointer++;
                        j++;
                        flag = true;
                }else {
                    flag = false;
                    break;
                }
            }
            if(flag){
                return true;
            }
           i++;
        }
        return flag;
    }

    public static void revArray(String[] arr,int start){
        int i= start;
        int j= arr.length-1;
        while(i<j){
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

}
