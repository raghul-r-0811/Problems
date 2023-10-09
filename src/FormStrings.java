import java.util.Arrays;

public class FormStrings {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("enter max char per line");
//        int MaxLength = scanner.nextInt();
//        System.out.println("enter favorites character");
//        scanner.nextLine();
//        String favCharAsString = scanner.nextLine();
//        char favChar = favCharAsString.charAt(0);
//                System.out.println("enter total number of words");
//        int totalWords = scanner.nextInt();
//        System.out.println("enter the words");
//        scanner.nextLine();
//        String[] strArr = new String[totalWords];
        int MaxLength = 10;
        char favChar = 'o';
        String[] strArr = {"Zoho","Eating","Watching","Pogo","Loving","Mango"};

        for(int i=0;i<strArr.length;i++){
            strArr[i]  = strArr[i].toLowerCase();
        }
        System.out.println(Arrays.toString(strArr));
        int[] lengthArr = new int[strArr.length];
        for(int i=0;i<strArr.length;i++){
            for(int j=0;j<strArr[i].length();j++){
                if(strArr[i].charAt(j) != favChar){
                    lengthArr[i]++;
                }
            }
        }
        System.out.println(Arrays.toString(lengthArr));
        for(int i = 0; i< lengthArr.length; i++){
            if(lengthArr[i] == 0){
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(strArr[i]);
            sb.append(" ");
            int currentLength = lengthArr[i];
            for(int j = i+1; j< lengthArr.length; j++){
                if(currentLength + lengthArr[j] > MaxLength || lengthArr[j] == 0){
                    break;
                }
                System.out.println("now i = "+i+"and j ="+j);
                currentLength += lengthArr[j];
                sb.append(strArr[j]);
                lengthArr[j] = 0;
            }
            System.out.println(sb.toString());
            lengthArr[i] = 0;
            System.out.println();
        }
    }
}
