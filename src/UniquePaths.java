/**
 * Created by Cathal on 30/01/2017.
 */
public class UniquePaths {
        private int width;
        private int depth;
        private int[][] matrix;
        private int numberOfUniquePaths;


        public UniquePaths(int depth,int width){
            this.width = width;
            this.depth = depth;
            matrix = new int[depth][width];
        }

    public void printMatrix(){
        for(int row = 0;row < depth;row++) {
            for(int column = 0;column < width;column++) {
                System.out.print(matrix[row][column] + " , ");
            }
            System.out.println("");
        }
    }

    public int calculateNumberOfUniquePaths(){
        if(width == 1 || depth == 1){
            numberOfUniquePaths = 1;
        }
        else if(width == 2 || depth == 2){
            if(width >= depth){
                numberOfUniquePaths =  width;
            }else{
                numberOfUniquePaths = depth;
            }
        }
        else {
            for (int row = 0; row < depth; row++) {
                matrix[row][width - 1] = 1;
            }

            for (int row = depth - 2; row >= 0; row--) {
                for (int column = width - 2; column >= 0; column--) {
                    matrix[row][column] = matrix[row + 1][column] + matrix[row][column + 1];
                }
            }

            for (int colNo = 0; colNo < width; colNo++) {
                numberOfUniquePaths += matrix[0][colNo];
            }
        }
        return numberOfUniquePaths;
    }


    public static void main(String[] args){
        UniquePaths run = new UniquePaths(10,10);
        System.out.println(run.calculateNumberOfUniquePaths());
    }
}
