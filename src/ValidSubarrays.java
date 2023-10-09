import java.util.Arrays;

public class ValidSubarrays {
    public static void main(String[] args) {
        int[] inputArr = {34,145,67,1004,88,456,2034};
        int window = 3;
        int fav = 8;
        for(int i = 0;i<inputArr.length;i++){
            if(i+3 <= inputArr.length){
                int[] windArr = subCutter(inputArr,i,i+3);
                int  maxi = MaxPosition(windArr);
                boolean valid = checkValid(windArr,fav);

                System.out.print(Arrays.toString(windArr));
                System.out.print(" : "+ maxi+ " - ");
                if(valid){
                    System.out.print("valid subarray");
                }else{
                    System.out.print("not a Valid Subarray");
                }

                System.out.println();
            }
        }
    }

    public static int[] subCutter(int[] intarr,int start, int end){
        int[] retarr = new int[end - start];
        int j=0;
        for(int i=start;i<end;i++){
            retarr[j] = intarr[i];
            j++;
        }
        return retarr;
    }

    public static int MaxPosition(int[] intarr){
        int[] copyIntarr = Arrays.copyOf(intarr,intarr.length);
        int sum = 0;
        int greastestInIntarr = findGreates(intarr);

        while(greastestInIntarr != 0){
            int[] maxPosarr = new int[intarr.length];
            for(int i =0;i<intarr.length;i++){
                maxPosarr[i] = copyIntarr[i] % 10;
                copyIntarr[i] = copyIntarr[i]/10;
            }
            int currentmax = findGreates(maxPosarr);
            sum =  sum*10 + currentmax ;
            greastestInIntarr /=10;
        }

        return reverseIntger(sum);
    }

    public static int findGreates(int[] intarr){
        int greatest = Integer.MIN_VALUE;
        for(int i=0;i<intarr.length;i++){
            if(intarr[i] > greatest){
                greatest = intarr[i];
            }
        }
        return greatest;
    }

    public static int reverseIntger(int num){
        int sum =0;
        while(num != 0){
            int ans = num % 10;
            sum = sum*10+ ans;
            num /=10;
        }
        return sum;
    }
    public static boolean checkValid(int[] intarr,int fav ){
        String str = Arrays.toString(intarr);
        String favchar = Integer.toString(fav);
        char favorite = favchar.charAt(0);
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == favorite){
                return true;
            }
        }
        return false;
    }
}
