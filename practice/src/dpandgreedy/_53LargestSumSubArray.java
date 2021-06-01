package dpandgreedy;

public class _53LargestSumSubArray {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, -10, -3 };
		int k = 4;
		solution(arr, k);
	}

	public static void solution(int[] arr, int k) {
		int[] maxSum = new int[arr.length];
		// use kadane's
		maxSum[0] = arr[0];
		for(int i = 1 ; i < arr.length; i++) {
			maxSum[i] = Math.max(arr[i], maxSum[i - 1] + arr[i]);
		}
		
		int sum = 0 ;
		for(int i = 0 ; i < k; i++) {
			sum += arr[i];
		}
		
		int ans = sum;;
		for(int i = k ; i < arr.length; i++) {
			sum = sum + arr[i] - arr[i - k];
			ans = Math.max(ans, sum);
			ans = Math.max(ans, sum + maxSum[i - k]);
		}
		
		System.out.println(ans);
	}

}
