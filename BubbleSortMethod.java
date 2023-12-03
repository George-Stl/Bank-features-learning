package GitRepositoryVSC;

public class BubbleSortMethod {
    public static void main(String[]args){
        System.out.println("\tМатрица");
        int[][] matrix = new int[3][4];
        for(int row = 0; row < matrix.length; row++){
            for (int column = 0; column < matrix[row].length; column++){
                matrix[row][column] = (int)(Math.random() * 100);
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println("\n");
        }
        matrix = sortMatrix(matrix);
        
        System.out.println("\tОтсортированная матрица");
        
        for(int row = 0; row < matrix.length; row++){
            for (int column = 0; column < matrix[row].length; column++){
                
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println("\n");
        }
    }


    public static int[][] sortMatrix(int[][]list){
        
        for (int row = 0; row < list.length; row++){
            int l = 0;
            while (l < list[row].length - 1){
                for (int column = l; column < list[row].length - 1; column++){
                    int minValue = list[row][column];
                    if(minValue > list[row][column + 1]){
                        int temp = list[row][column + 1];
                        list[row][column + 1] = minValue;
                        list[row][column] = temp;
                    }
                }
                l++;
            }      
        }
        return list;
    }
}
