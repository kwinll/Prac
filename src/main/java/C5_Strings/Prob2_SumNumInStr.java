package C5_Strings;

public class Prob2_SumNumInStr {

	private static boolean isNum(char character) {
		final char zero = '0';
		final char nine = '9';

		boolean result = (int) character >= (int) zero && (int) character <= (int) nine ? true : false;
		return result;

	}

	public static int calculate(String string) {
		int result = 0;
		int symbol = 1;
		string += "#";
		StringBuffer stringBuffer = new StringBuffer();

		for (int i = 0; i < string.length(); ++i) {
			char theCha = string.charAt(i);

			if (isNum(theCha))
				stringBuffer.append(theCha);
			else {
				if (theCha == '-')
					symbol *= -1;
				else {
					if (stringBuffer.length() != 0) {

						result += symbol * Integer.parseInt(stringBuffer.toString());
						stringBuffer = new StringBuffer();
					}
					symbol = 1;
				}
			}
		}

		
		
		return result;
	}

	public static void main(String[] args) {
		System.out.println(calculate("A-1B--2C-D6E"));
	}

}
