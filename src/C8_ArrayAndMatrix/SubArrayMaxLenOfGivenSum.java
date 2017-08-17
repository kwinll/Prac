package C8_ArrayAndMatrix;
/**
 * arr[1,3,5,2,1,1,3]
 * return 2 1 1 3
 * length 4
 *
 * **/
public class SubArrayMaxLenOfGivenSum {
    public static void main(String[] args){
        //int[] arr = new int[]{1,3,5,2,1,1,3};
        int[] arr = new int[]{1,2,1,1,1};
        //int n = 7;
        int n = 3;
        int start = 0;
        int end = 0;
        int maxLen = 0;
        int sum = 0;

        for(int i = 0 ; i < arr.length ; ++i){
            if(sum +  arr[i] < n){
                sum += arr[i];
                end = i;

            }
            else{
                if(sum+ arr[i] == n){
                    end = i;
                    if(end - start > maxLen){
                        maxLen = end - start;
                        System.out.println("The start is " + start + " The end is " + end + " And len is " + (maxLen+1));
                    }
                }
                start = i;
                end = i;
                sum = arr[i]; // sum = 0; sum += arr[i]
            }


        }


    }

}
