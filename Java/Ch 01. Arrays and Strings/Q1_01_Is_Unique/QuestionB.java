package Q1_01_Is_Unique;

public class QuestionB {

	/* Assumes only letters a through z. */

	/**
	 * http://www.asciitable.com/ 아스키코드 참조
	 * a - z 까지는 26개 차이가 난다. 해당 알파벳에서 a를 빼면 그 차이 값을 알수 있음.
	 * 2^1(a), 2^2(b), 2^3(c) ... 2^26(z)
	 * a - z 를 bit 연산자로 나타낸다면
	 * a = ... 0001 (1)
	 * b = ... 0010 (2)
	 * c = ... 0100 (4) 이렇게 나타낼 수 있음.
	 * bit AND 연산으로 같은 자리에 1이 있는지 판단 한다.
	 * 예를 들면 누적된 비트 연산이 0011일 때 알파벳 c가 들어온다고 가정한다면 0010이 되고 AND 연산을 진행할때 두번째 자리 1이 같아 값이 0 이상 이므로 중복 체크가 가능하다.
	 * checker 값에는 OR 연산 값을 누적시킨다.
	 * 즉 비트 연산이란 10진수를 2진수로 바꿔 연산하는것.. int checker 변수엔 2진수 연산된 10진수가 들어 있음..
	 **/
	public static boolean isUniqueChars(String str) {
		if (str.length() > 26) { // Only 26 characters
			return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);
		}
		return true;
	}

	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word));
		}
	}

}
