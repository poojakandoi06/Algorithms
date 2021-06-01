package dpandgreedy;
import java.util.*;

public class _13LongestAndCountPalinSubString {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		longest(str);
		count(str);
	}

	private static void count(String str) {
		int ans = 1;
		for(int i = 1; i < str.length() - 1; i++) {
			int low = i - 1;
			int hi = i + 1;
			while(low >= 0 && hi < str.length() && str.charAt(low) == str.charAt(hi)) {
				if(hi - low + 1 > ans) {
					ans = hi - low + 1;
				}
				low--;
				hi++;
			}
			low = i -1;
			hi = i;
			while(low >= 0 && hi < str.length() && str.charAt(low) == str.charAt(hi)) {
				if(hi - low + 1 > ans) {
					ans = hi - low + 1;
				}
				low--;
				hi++;
			}
		}
		System.out.println(ans);
	}

	private static void longest(String str) {
		int ans = 1;
		for(int i = 1; i < str.length() - 1; i++) {
			int low = i - 1;
			int hi = i + 1;
			while(low >= 0 && hi < str.length() && str.charAt(low) == str.charAt(hi)) {
				if(hi - low + 1 > ans) {
					ans = hi - low + 1;
				}
				low--;
				hi++;
			}
			low = i -1;
			hi = i;
			while(low >= 0 && hi < str.length() && str.charAt(low) == str.charAt(hi)) {
				if(hi - low + 1 > ans) {
					ans = hi - low + 1;
				}
				low--;
				hi++;
			}
		}
		System.out.println(ans);
	}

}
