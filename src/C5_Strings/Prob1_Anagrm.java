package C5_Strings;

import java.util.HashMap;

public class Prob1_Anagrm {

	public static boolean isAnagrm(String a, String b) {
		if (a.length() != b.length())
			return false;

		HashMap<Character, Integer> aMap = new HashMap<>();
		HashMap<Character, Integer> bMap = new HashMap<>();
		for (int i = 0; i < a.length(); ++i) {
			put(aMap, a.charAt(i));
			put(bMap, b.charAt(i));
		}

		for (Character key : aMap.keySet()) {

			if (!aMap.get(key).equals(bMap.get(key)))
				return false;
		}
		return true;

	}

	public static void put(HashMap<Character, Integer> map, Character key) {
		Integer num = map.get(key);

		if (num == null)
			map.put(key, 1);
		else
			map.put(key, ++num);
	}

	public static void main(String[] args) {

		String aString = "123";
		String bString = "231";

		System.out.println(isAnagrm(aString, bString));
	}

}
