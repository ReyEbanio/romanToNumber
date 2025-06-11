package romanToInteger;

public class IntegerToRoman {
	public static void main(String[] args) {
		// get count = 3
		// search for 3length in index 1
		// Subtract
		// 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
		// get count = repeat
		int input = 2000;
		String answer = "";
		String checkValue = "";
		String inputString = String.valueOf(input);
		int stringCounter = 0;
		
		while (input > 0) {
			char valueChar = inputString.charAt(stringCounter);
			checkValue += valueChar;
			if (!checkValue.equals("0")) {
				int addZeroCounter = String.valueOf(input).length();
				checkValue += getValue(addZeroCounter);
				input -= Integer.parseInt(checkValue);
				answer += getRomanEqui(checkValue);
				checkValue = "";
			}
			stringCounter++;
		}
		System.out.println(answer);
	}

	public static String getValue(int length) {
		String addZero = "";
		for (int i = 0; i < length - 1; i++) {
			addZero += "0";
		}
		return addZero;
	}

	public static String getRomanEqui(String checkValue) {
		String value = "";
		String[][] integerRoman = { { "X", "5000" },  { "M", "1000" }, { "D", "500" }, { "C", "100" }, { "L", "50" }, { "X", "10" },
				{ "V", "5" }, { "I", "1" } };

		int input = Integer.parseInt(checkValue);
		System.out.println(input);
		// 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
		switch(input) {
		case 4: return "IV";
		case 9: return "IX";
		case 40: return "XL";
		case 90: return "XC";
		case 400: return "CD";
		case 900: return "CM";
		}
		for (int x = 0; x < integerRoman.length - 1; x++) {
			int toCompare = Integer.parseInt(integerRoman[x][1]);
			int belowValue = Integer.parseInt(integerRoman[x + 1][1]);

			if (input <= toCompare && input >= belowValue || input > 1000 && input < 4000) {
				if (belowValue * 4 != input) {
					while ((input - belowValue) >= 0) {
						if (input >= 1000) {
							input -= belowValue;
							value += integerRoman[x][0];
						} else {
							input -= belowValue;
							value += integerRoman[x + 1][0];
						}
					}
				} else {
					value += integerRoman[x + 1][0];
					input -= belowValue;
				}
			}
		}
		return value;
	}

}
