package C8_ArrayAndMatrix;

/**
 * Used to check the minimum number which does not exists in the current array
 *
 * @author alex
 * @version 1.0
 */
public class MiniumNumberNotAppearlInArr {
    public int getMiniumNotApper(int[] arr) {
        int index = 0;
        int e = arr.length;

        while (index < e) {
            if (arr[index] == index + 1) {
                index++;
            }
            // Do not fulfile the bund or has duplicate value
            else if(arr[index] <= index || arr[index] > e || arr[index] == arr[arr[index] -1]){
                arr[index] = arr[--e];
            }
            // Move the correct place
            else{
                swap(arr,index, arr[index]-1);
            }
        }
        return  index +1;
    }


    public void swap(final int[] arr, int from, int to) {
        if (from < 0 || from >= arr.length || to < 0 || to >= arr.length)
            throw new RuntimeException("Indexes are not valid");

        int tmp = arr[from];

        arr[from] = arr[to];
        arr[to] = tmp;
    }

    public static void main(String[] args){
        int[] arr =new int[]{-1,0,1,3,5,3,-5,1};

        MiniumNumberNotAppearlInArr min = new MiniumNumberNotAppearlInArr();

        System.out.println(min.getMiniumNotApper(arr));


    }


}
