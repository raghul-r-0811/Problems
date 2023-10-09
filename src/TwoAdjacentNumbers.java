import java.util.Arrays;

public class TwoAdjacentNumbers {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,4,6,2},{3,5,8,9,0},{1,7,3,2,4},{2,3,1,4,2},{6,4,3,2,1}};
        int fav = 10;
        for(int i=0;i< matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
        PrintAdjacentNumbers(matrix,fav);


    }

    public static void PrintAdjacentNumbers(int[][] matrix,int fav){
        int checkNum = 0;
        for(int i=0;i< matrix.length;i++){
            for(int j =0;j< matrix.length;j++){
                int currentNum = matrix[i][j];
               // System.out.println("current num = "+ currentNum +" --> i = "+i+" --> j = "+j);
                if(j+1 < matrix.length-1){
                    checkNum = currentNum + matrix[i][j+1];
                    if(checkNum == fav){
                        System.out.println("left to right "+currentNum +" + "+matrix[i][j+1]+" : "+fav);
                    }
                    checkNum = currentNum + matrix[j+1][i];
                    if(checkNum == fav){
                        System.out.println("top to down "+currentNum +" + "+matrix[j+1][i]+" : "+fav);
                    }
                }
                if(i+1 < matrix.length -1 && j-1 >= 0){
                    checkNum = currentNum + matrix[i+1][j-1];
                    if(checkNum == fav){
                        System.out.println(" / diagonal "+currentNum +" + "+matrix[i+1][j-1]+" : "+fav);
                    }
                }
                if(i+1 < matrix.length-1 && j+1 <= matrix.length-1){
                    checkNum = currentNum + matrix[i+1][j+1];
                    if(checkNum == fav){
                        System.out.println("\\ diagonal"+currentNum +" + "+matrix[i+1][j+1]+" : "+fav);
                    }
                }

            }

        }
    }


}
