package dpandgreedy;
import java.util.*;

public class _119MaximumSubArray {

	public static void main(String[] args) {
		
	}
	
	public static void solution(int[] arr) {
		int ans = 0;
		int currSum = 0;
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < arr.length; i++) {
			currSum += arr[i];
			currSum = Math.max(currSum, arr[i]);
			if(arr[i] > max) {
				max = arr[i];
			}
			ans = Math.max(ans, currSum);
		}
		System.out.println(ans > 0 ? ans : max);
	}

}
