package dpandgreedy;

import java.util.*;
public class _144PairsWithSpecificDifference {

	public static void main(String[] args) {
		 Scanner scn = new Scanner(System.in);
	 	 	 int n = scn.nextInt();
	 	 	 int a[] = new int[n];
	 	 	 for (int i = 0; i < n; i++) {
	 	 	 	 a[i] = scn.nextInt();
	 	 	 }
	 	 	 int k = scn.nextInt();
         Arrays.sort(a);
         solution(a,k);

	}
	
	public static void solution(int[] arr, int k) {
		Arrays.sort(arr);
		int ans = 0;
		for(int i = arr.length - 1; i >= 1; ) {
			if(arr[i] - arr[i - 1] < k) {
				ans += (arr[i] + arr[i - 1]);
				i -= 2;
			}else {
				i--;
			}
		}
		System.out.println(ans);
	}

}
