package dpandgreedy;

public class _116MaxDiffZeroesAndOnes {

	public static void main(String[] args) {
		String str = "11000010001";
		solution(str);
	}

	public static void solution(String str) {
		int ans = 0;
		int currSum = 0;
		for (int i = 0; i < str.length(); i++) {
			currSum += str.charAt(i) == '0' ? 1 : -1;
			if (currSum < 0) {
				currSum = 0;
			}
			ans = Math.max(ans, currSum);
		}
		if (ans == 0) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

}
