/**
 * Merge Sort
 */
public class Two_MergeSort {

    public static void mergeSort(final int[] arr, int start, int end) {
        if (end - start <= 0)
            return;


        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        int j = mid + 1;
        int i = start;
        int index = start;

        int[] tmp = arr.clone();

        while (i <= mid || j <= end) {
            if(i > mid && j <= end){
                tmp[index++] = arr[j++];
            }
            if(j > end && i <= mid){
                tmp[index++] = arr[i++];
            }

            if (i <= mid && j <= end){
               if(arr[i] <= arr[j]){
                   tmp[index++] = arr[i++];
               }
               else{
                   tmp[index++] = arr[j++];
               }

            }
        }

        for(int m = start ; m <= end; ++m)
            arr[m] = tmp[m];
    }


    public static void main(String[] args){
        int[] arr = new int[]{6,5,3,1,8,7,2,4};

        mergeSort(arr,0,7);

        for(int i = 0 ;i < arr.length ; ++i){
            System.out.println(arr[i]);
        }
    }

}
