import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

/**
 * Quick Sort
 *
 * @author alex
 **/
public class One_QuickSort {
    public static void swap(int[] arr, int index1, int index2) {
        if (index1 >= arr.length || index2 > arr.length || index1 < 0 || index2 < 0)
            throw new RuntimeException("Index out of range");

        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }


    public static void QuickSort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        else {
            int i = start;
            int pivot = arr[start];
            for (int j = start + 1; j <= end; ++j) {
                if(arr[j] < pivot)
                    swap(arr, ++i, j);

            }
            swap(arr, start, i);

            QuickSort(arr, start, i -1);
            QuickSort(arr, i+1, end);

        }

    }


    public static void main(String[] args){
           int[] arr = new int[] {5,4,6,1,8,9,3};

           QuickSort(arr,0, arr.length-1);


           for(int n = 0 ; n < arr.length ; ++n){
               System.out.println(arr[n]);
           }

    }

    @Test
    public void testSwap(){

        int[] arr= new int[]{1,2,3,4,5,6,7};
        swap(arr, 0 ,1);

        Assertions.assertEquals(arr[1],1);

    }
}
