import java.util.Arrays;

public class PrintSubarray {
    public static void main(String[] args) {
        int[] intarr = {1,2,3,4,5,6};
        printSubarrays(intarr);

    }
    public static void printSubarrays(int[] array) {
        int n = array.length;

        for (int start = 0; start < n; start++) {
            System.out.println(array[start]);
            for (int end = start+1 ; end < n; end++) {
                System.out.print(array[start] + ","+array[end]);
                System.out.println();
                for(int i=start;i< end;i++){
                    for(int j=i+1;j<end;j++){

                    }

                }
            }
        }

    }

    public static int[] retArray(int[] array,int start,int end){
        int[] ret = new int[end - start];
        int j=0;

        return ret;
    }
}
