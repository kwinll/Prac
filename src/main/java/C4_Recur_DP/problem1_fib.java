package C4_Recur_DP;

import java.util.HashMap;

public class problem1_fib {

	public static int[][] arr = { { 1, 1 }, { 1, 0 } };

	public static HashMap<Integer, Map> hashMap = new HashMap<>();

	static {
		hashMap.put(1, new Map(1, 1, 1, 0));
	}

	public static Map calc(int n) {
		if (n == 1)
			return new Map(1, 1, 1, 0);

		int first_half = n / 2;
		int second_half = n - n / 2;

		Map left = hashMap.get(first_half);
		Map right = hashMap.get(second_half);
		if (left == null)
			left = calc(first_half);
		if (right == null)
			right = calc(second_half);

		Map result = new Map();

		result.setA(left.getA() * right.getA() + left.getB() * right.getC());
		result.setB(left.getA() * right.getB() + left.getB() * right.getD());
		result.setC(left.getC() * right.getA() + left.getD() * right.getC());
		result.setD(left.getC() * right.getB() + left.getD() * right.getD());

		hashMap.put(n, result);
		return result;

	}
	
	public static int fib(int n ){
		if(n == 1 || n == 2)
			return 1;
		
		Map map = calc(n -2);
		return map.getA() + map.getC();
		
	}

	public static void main(String[] args) {

		Map map = calc(10);
		System.out.println(map.getA()+ " " + map.getB());
		System.out.println(map.getC() + " " + map.getD());
		
		System.out.println(fib(6));

	}

}
