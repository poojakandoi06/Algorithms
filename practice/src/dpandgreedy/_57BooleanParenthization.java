package dpandgreedy;

import java.util.*;

public class _57BooleanParenthization {

	public static void main(String[] args) {
		String str1 = "TTFT";
		String str2 = "|&^";
		solution(str1, str2);
	}

	private static void solution(String str1, String str2) {
		int n = str1.length();
		int[][] t = new int[n][n];
		int[][] f = new int[n][n];
		for (int gap = 0; gap < n; gap++) {
			int si = 0, ei = gap;
			while (ei < n) {
				if (gap == 0) {
					t[si][ei] = str1.charAt(si) == 'T' ? 1 : 0;
					f[si][ei] = str1.charAt(si) == 'F' ? 1 : 0;
				} else {
					for (int cp = si; cp < ei; cp++) {
						char sign = str2.charAt(cp);
						if (sign == '&') {
							t[si][ei] += t[si][cp] * t[cp + 1][ei];
							f[si][ei] += ((t[si][cp] * f[cp + 1][ei]) + (f[si][cp] * t[cp + 1][ei])
									+ (f[si][cp] * f[cp + 1][ei]));
						}
						if (sign == '|') {
							t[si][ei] += ((t[si][cp] * t[cp + 1][ei]) + (t[si][cp] * f[cp + 1][ei])
									+ (f[si][cp] * t[cp + 1][ei]));
							f[si][ei] += ((f[si][cp]) * (f[cp + 1][ei]));
						}
						if (sign == '^') {
							t[si][ei] += ((t[si][cp] * f[cp + 1][ei]) + (f[si][cp] * t[cp + 1][ei]));
							f[si][ei] += ((t[si][cp] * t[cp + 1][ei]) + (f[si][cp] * f[cp + 1][ei]));
						}
					}
				}
				si++;
				ei++;
			}
		}
		System.out.println(t[0][t[0].length - 1]);
	}

}
