package C8_ArrayAndMatrix;

import java.util.HashMap;

/**
 * Find the max sub array of the array, the element inside the array could any integers: positive, negative or zero
 * Using s(i) to represent sum from arr[0] to arr[i], thus sum(arr[i],arr[i]) could use the expression: s(i) - s(j-1)
 * The key here is to use hashmap to store the the sum value and the first place that sum value appera
 * Key -> s(i)'s value
 * Value -> the first place that the value appear
 *
 * If given N =3
 * Arr: -4 -5 1 0 2 -1 -3
 * The max sub array would be -5 -1 0 2 1
 * @author alex
 * */
public class MaxSubArrayOfAnyGivenInt {

    /**
     * Get the max length of sub array
     * Complexity O(n)
     *
     * @return length
     *
     * */
    public int getMaxLengthOfSubArr(int[] arr, int n){
        int len = 0;
        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,-1);
        for(int i = 0 ; i < arr.length ; ++i){
            sum += arr[i];
            if(map.get(sum-n) !=null){
                int tmpLen = i - map.get(sum-n);
                if(tmpLen > len)
                    len = tmpLen;
            }
            if(map.get(sum) == null) {
                map.put(sum, i);
            }
            else{
              if(i < map.get(sum))
                  map.put(sum,i);
            }
        }

        return  len;

    }

}
