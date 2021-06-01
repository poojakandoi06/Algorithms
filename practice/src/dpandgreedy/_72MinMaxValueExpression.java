package dpandgreedy;

import java.util.*;

public class _72MinMaxValueExpression {

	public static void main(String[] args) {
		String s = "1+2*3+4*5";
		String str1 = "";
		String str2 = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '+' || ch == '*') {
				str2 += ch;
			} else {
				str1 += ch;
			}
		}
		solution(str1, str2);
	}

	private static void solution(String str1, String str2) {
		int n = str1.length();
		int[][] min = new int[n][n];
		int[][] max = new int[n][n];
		for (int i = 0; i < min.length; i++) {
			Arrays.fill(min[i], Integer.MAX_VALUE);
			Arrays.fill(max[i], Integer.MIN_VALUE);
		}

		for (int gap = 0; gap < n; gap++) {
			int si = 0, ei = gap;
			while (ei < n) {
				if (gap == 0) {
					min[si][ei] = str1.charAt(si) - '0';
					max[si][ei] = str1.charAt(si) - '0';
				} else if (gap == 1) {
					if (str2.charAt(si) == '+') {
						min[si][ei] = max[si][ei] = (str1.charAt(si) - '0') + (str1.charAt(ei) - '0');
					} else if (str2.charAt(si) == '*') {
						min[si][ei] = max[si][ei] = (str1.charAt(si) - '0') * (str1.charAt(ei) - '0');
					}
				} else {
					for (int k = si; k < ei; k++) {
						char operator = str2.charAt(k);
						if (operator == '+') {
							min[si][ei] = Math.min(min[si][ei], min[si][k] + min[k + 1][ei]);
							max[si][ei] = Math.max(max[si][ei], max[si][k] + max[k + 1][ei]);
						} else {
							min[si][ei] = Math.min(min[si][ei], min[si][k] * min[k + 1][ei]);
							max[si][ei] = Math.max(max[si][ei], max[si][k] * max[k + 1][ei]);
						}
					}
				}
				si++;
				ei++;
			}
		}
		System.out.println(min[0][n - 1] + " " + max[0][n - 1]);
	}

}
