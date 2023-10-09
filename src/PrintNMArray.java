import java.util.Scanner;

public class PrintNMArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter total number of rows:");
        int row = scanner.nextInt();
        System.out.println("Enter Total number of coloumns:");
        int col = scanner.nextInt();
        System.out.println("Enter starting ponint row :");
        int spRow = scanner.nextInt();
        System.out.println("Enter starting point coloumn");
        int spCol = scanner.nextInt();

        int[][] reqMatrix = new int[row][col];
        fillMatrix(reqMatrix);
        printMatrix(reqMatrix,spRow,spCol);
    }

    public static int[][] fillMatrix(int matrix[][]){
        int num = 1;
        int  col = 0;
        int row;
        while(col < matrix[0].length ){
            if(col%2 == 0){
                 row = matrix.length-1;
                while(row >= 0){
                    matrix[row][col] = num;
                    row--;
                    num++;
                }
            }
            else {
                row = 0;
                while (row < matrix.length) {
                    matrix[row][col] = num;
                    row++;
                    num++;
                }
            }
            col++;
            }

        return matrix;
        }



    public static void printMatrix(int[][] matrix,int spRow,int spCol){
        int count = 0;
        while(count < matrix[0].length){
            if(spRow == 0){
                int row = spRow;
                while(row < matrix.length){
                   System.out.print(matrix[row][spCol]+" ");
                    row++;
                }
                spRow = matrix.length-1;
            }else{
                int row = spRow;
                while(row >= 0){
                    System.out.print(matrix[row][spCol]+" ");
                    row--;
                }
                spRow = 0;
            }
            System.out.println();
            spCol++;
            spCol = spCol %(matrix[0].length) ;



            count++;
        }
    }
}
