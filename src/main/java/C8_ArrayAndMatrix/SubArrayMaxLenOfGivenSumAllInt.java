package C8_ArrayAndMatrix;

public class SubArrayMaxLenOfGivenSumAllInt {
    public static void main(String[] args){
        //int[] arr = new int[]{1,3,5,2,1,1,3};
        int[] arr = new int[]{-2,-1,3,4,0,0,0,-1,-3};
        //int n = 7;
        int n = 4;
        int start = 0;
        int end = 0;
        int maxLen = 0;
        int sum = 0;

        for(int i = 0 ; i < arr.length ; ++i){
            if(sum +  arr[i] <= n){
                sum += arr[i];
                end = i;
                if(sum == n){
                    if(end - start > maxLen){
                        maxLen = end - start;
                        System.out.println("The start is " + start + " The end is " + end + " And len is " + (maxLen+1));
                    }
                }

            }
            else{

                start = i;
                end = i;
                sum = arr[i]; // sum = 0; sum += arr[i]
            }


        }


    }
}
