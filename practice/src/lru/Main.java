package lru;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String s = sc.next();
			int x = sc.nextInt();
			int[] arr = new int[s.length()];
			Arrays.fill(arr, 1);
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '0') {
					if (i - x >= 0)
						arr[i - x] = 0;
					if (i + x < s.length())
						arr[i + x] = 0;
				}
			}
			int flag = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '1') {
					if ((i - x >= 0 && arr[i - x] == 0 && i + x < s.length() && arr[i + x] == 0)
							|| (i - x < 0 && i + x < s.length() && arr[i + x] == 0)
							|| (i + x >= s.length() && i - x >= 0 && arr[i - x] == 0) || (i-x<0 && i+x>=s.length())) {
						flag = 1;
						break;
					}

				}
			}
			if (flag == 1) {
				System.out.println(-1);
				continue;
			}

			else {

				StringBuilder sb = new StringBuilder();
				for (int i : arr) {
					sb.append(i);
				}
				System.out.println(sb.toString());
			}

		}
	}

}
//00111101110011011111111111111110101111101000110