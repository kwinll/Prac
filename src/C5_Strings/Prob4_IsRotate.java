package C5_Strings;

public class Prob4_IsRotate {
	public static boolean isRotate(String a, String b) {

		if (a == null || b == null || a.length() != b.length())
			return false;

		String re = a + a;

		return re.contains(b);

	}
	
	public static void main(String[] args) {
		
		String aString ="cdab";
		String bString="abcd";
		
		System.out.println(isRotate(aString, bString));
		
		String cString = "1ab2";
		String dString = "ab12";
		
		System.out.println(isRotate(cString, dString));
		
	}

}
