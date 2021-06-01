package dpandgreedy;
import java.util.*;

public class _117MaximumLengthOfPairChain {

	public static void main(String[] args) {
		

	}

	public static void solution(int[][] pairs) {
		Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
		int end = Integer.MIN_VALUE;
		int len = 0;
		for (int[] pair : pairs) {
			if (pair[0] > end) {
				len++;
				end = pair[1];
			} else {
				end = Math.min(pair[1], end);
			}
		}
		System.out.println(len);
	}

}
