import java.util.Scanner;

public class NextBiggestNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 6;
        int[] intarr = new int[n];

        for (int i = 0; i < n; i++) {
            intarr[i] = scanner.nextInt();
        }

       for(int i=0;i<n-1;i++){
          int pivot  = intarr[i];
          int rightpointer = i+1;
          int leftpointer = i;

          int check =0;
          while(check ==0 ){
              if(intarr[rightpointer]>intarr[i] && rightpointer <n){
                  System.out.print(intarr[i]+" -> "+intarr[rightpointer]+" ");
                  check++;
                  rightpointer++;
              }
              while(check==0){
              if(intarr[leftpointer]>intarr[i] && leftpointer >0){
                  System.out.print(intarr[i]+" -> "+intarr[leftpointer]+" ");
                  check++;
                  leftpointer--;
              }
              }
          }


       }
    }


}
