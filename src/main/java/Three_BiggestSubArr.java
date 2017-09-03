public class Three_BiggestSubArr {
    public static void main(String[] args){
        int[] arr = new int[]{1,-2,3,10,-4,7,2,-5};


        int sum = 0;
        int max = 0;

        int end = 0;

        for(int i = 0 ;i < arr.length ; ++i){
            sum += arr[i];
            if(sum  >= 0){
                if(sum >= max){
                    max = sum;
                    end = i;
                }

            }
            else{
                sum = 0;


            }
        }

        int tmp = 0;
        for(int i = end ; i >= 0; --i){
            tmp+= arr[i];
            if(tmp == max) {
                System.out.println("Start is " + i);
                break;
            }
        }



        System.out.println(max);

        System.out.println(end);

    }


}
