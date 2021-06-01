package dpandgreedy;

import java.util.*;

public class _203WrapAroundWord {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String p = scn.next();
		int count = findSubstringInWraproundString(p);
		System.out.println(count);
	}

	public static int findSubstringInWraproundString(String p) {
		if (p == null)
			return 0;
		final int N = p.length();
		if (N <= 1)
			return N;
		int[] count = new int[26];
		int len = 0;
		int pre = p.charAt(0) - 'a';
		for (int i = 0; i < N; i++) {
			int cur = p.charAt(i) - 'a';
			int diff = cur - pre;
			if (diff == 1 || diff == -25) {
				len++;
			} else {
				len = 1;
			}
			count[cur] = Math.max(count[cur], len);
			pre = cur;
		}
		int res = 0;
		for (int c : count) {
			res += c;
		}
		return res;
	}
}
