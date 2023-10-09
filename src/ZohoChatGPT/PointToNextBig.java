package ZohoChatGPT;


//from a given array of integers print the next bigger number for each number in the array
//
//        Examples :
//
//        Input : {8,4,1,9,6,2}
//        output : 8->9 , 4->6 , 1->2 , 9-> , 6->8, 2->4


public class PointToNextBig {
    public static void main(String[] args) {
        int[] intarr1 = {8,4,1,9,6,2};
        int[] intarr2 = {4,5,2,25};
        int[] intarr3 = {16,17,4,3,5,2};

        int[] sort1 = arraysort(intarr1);



        pointFunction(intarr1);
        System.out.println("\n");
        pointFunction(intarr2);
        System.out.println("\n");
        pointFunction(intarr3);
        System.out.println("\n");
    }

    public static void pointFunction(int[] intarr){
        int[] sortedarr = arraysort(intarr);
        for(int i= 0;i< intarr.length;i++){
            System.out.print(intarr[i]+"->");
            for(int j =0;j< intarr.length-1;j++){
                if(intarr[i] == sortedarr[j] ){
                    System.out.print(sortedarr[j+1]);
                }
            }
            System.out.print(" , ");
        }
    }

    public static int[] arraysort(int[] intarr){
        int[] sortedarray = new int[intarr.length];
        for(int i=0;i<intarr.length;i++){
            sortedarray[i] = intarr[i];
        }
        for(int i = 0;i< intarr.length;i++){
            for(int j=i+1;j< intarr.length;j++){
                if(sortedarray[i]>sortedarray[j]){
                    int temp = sortedarray[i];
                    sortedarray[i] = sortedarray[j];
                    sortedarray[j] = temp;
                }
            }
        }
        return sortedarray;
    }

    public static void printarr(int[] intarr){
        for(int i = 0 ;i< intarr.length;i++){
            System.out.print(intarr[i]+" ");
        }
    }
}
