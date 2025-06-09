package romanToInteger;
public class RomanToInteger {
     static String[][] romanContainer = {
    		 {"M", "1000"},
    		 {"D", "500"},
			{"C", "100"},
			{"L", "50"},
			{"X", "10"},
			{"V", "5"},
			{"I", "1"}
	};
	public static void main(String[] args) {
		String romanI = "I"; 
		int previousValue = 0;
		int total = 0;
		int romValue = 0;
		for(int i = 0; i < romanI.length(); i++) {
			char roman = romanI.charAt(i);
			romValue = getValueRoman(roman);
			if(i>0 && previousValue < romValue) {
				total-=previousValue*2;
				total+=romValue;
			}else {
				total+=romValue;
			}
			previousValue = romValue;
		}
		System.out.println(total);
	}
	public static int getValueRoman(char getVal) {
		for(int i = 0; i<romanContainer.length; i++) {
			String s = romanContainer[i][0];
			if(s.equals(String.valueOf(getVal))) {
				return Integer.parseInt(romanContainer[i][1]);
			}
		}
		return 0;
	}
}
