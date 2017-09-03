package C8_ArrayAndMatrix;

/**
 * Caculate the submatrix which cointains the max value
 * @author Alex Zhang
 * */
public class MaxSubMatrix {

    public static void main(String[] args) {
        MaxSubMatrix maxSubMatrix = new MaxSubMatrix();
        maxSubMatrix.mergeMatrixToArr(null, 0,0);
    }

    public int calculateMaxSubMatrix(int[][] matrix){
        int max =0;
        for(int i = 0 ;i < matrix.length ; ++i){
            for(int j = i; j < matrix.length ;++j){
                int res = getMaxSubArray(mergeMatrixToArr(matrix,i,j));
                if(res > max)
                    max = res;

            }
        }
        return max;
    }


    /**
     * Get the max sub-array of the given array
     * */
    public int getMaxSubArray(int[] arr){
        int max = 0;
        int sum = 0;
        int lastIndex = 0;
        for(int i = 0 ; i< arr.length ; ++i){
            if(sum+arr[i] < 0){
                sum = 0;
            }
            else{
                if(sum+ arr[i] > max){
                    max = sum + arr[i];
                    lastIndex =i;
                }
                sum += arr[i];
            }
        }return max;
    }


    /**
     * Merge the specific matrix into an array
     * @param from the from index
     * @param to  the to index
     * */
   public int[] mergeMatrixToArr(final int[][] matrix, int from, int to){
       if(matrix == null)
           throw new NullPointerException("This is a null matrix");
       if(from > to ||  from < 0 || from > matrix.length || to < 0 || to > matrix.length)
           throw new IllegalArgumentException("Please given the correct from and to index");

       int[] finalResult = new int[matrix[0].length];

       for(int column = 0; column < matrix[0].length ; ++column){
           int tmp = 0;
           for(int i = from; i <= to; ++i){
              tmp += matrix[i][column];
           }
           finalResult[column] = tmp;
       }
       return finalResult;
   }
}

