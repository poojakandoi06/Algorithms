package dpandgreedy;
import java.util.*;
public class _34LCSthreeStrings {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str1 = scn.next();
		String str2 = scn.next();
		String str3 = scn.next();
		solution(str1,str2,str3);
	}

	private static void solution(String str1, String str2, String str3) {
		int[][][] dp = new int[str1.length() + 1][str2.length() + 1][str3.length() + 1];
		dp[str1.length()][str2.length()][str3.length()] = 1;
		for(int i = str1.length() - 1; i >= 0; i--) {
			char chi = str1.charAt(i);
			for(int j = str2.length() - 1; j >= 0; j--) {
				char chj = str2.charAt(j);
				for(int k = str3.length() - 1; k >= 0; k--) {
					char chk = str3.charAt(k);
					if(chi == chj && chi == chk) {
						dp[i][j][k] = dp[i + 1][j + 1][k + 1] + 1;
					}else {
						dp[i][j][k] = Math.max(dp[i + 1][j][k], Math.max(dp[i][j + 1][k], dp[i][j][k + 1]));
					}
				}
			}
		}
		System.out.println(dp[0][0][0]);
	}

}
