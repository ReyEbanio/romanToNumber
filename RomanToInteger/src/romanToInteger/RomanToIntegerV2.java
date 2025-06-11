package romanToInteger;

public class RomanToIntegerV2 {
	static String[] romanEquivalent = {"M","CM","D","CD","C", "XC", "L","XL","X","IX","V","IV","I"};
	static int[] romansValue = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	
	public static void main(String[] args) {
		int input = 9;
		System.out.println(getEquivalent(input));
	}
	public static String getEquivalent(int input) {
		StringBuilder answer = new StringBuilder(); 
		for(int i = 0 ; i < romansValue.length; i++) {
			while(input >= romansValue[i]) {
				answer.append(romanEquivalent[i]);
				input -= romansValue[i];
			}
		}
		return answer.toString();
	}
}
