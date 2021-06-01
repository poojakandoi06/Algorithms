package dpandgreedy;
import java.util.*;

public class _118MaximumLengthOfRepeatedSubArray {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n1 = scn.nextInt();
		int[] arr1 =  new int[n1];
		for(int i = 0 ; i < n1; i++) {
			arr1[i] = scn.nextInt();
		}
		int n2 = scn.nextInt();
		int[] arr2 = new int[n2];
		for(int i = 0 ; i < n2; i++) {
			arr2[i] = scn.nextInt();
		}
		solution(arr1, arr2);

	}
	
	public static void solution(int[] arr1, int[] arr2) {
		int[][] dp = new int[arr1.length + 1][arr2.length + 1];
		int ans = 0;
		for(int i = 1 ; i <= arr1.length; i ++) {
			for(int j = 1; j <= arr2.length ;i++) {
				if(arr1[i - 1] == arr2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				ans = Math.max(ans, dp[i][j]);
			}
		}
		System.out.println(ans);
	}

}
