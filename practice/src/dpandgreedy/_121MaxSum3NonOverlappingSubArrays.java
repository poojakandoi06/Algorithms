package dpandgreedy;

public class _121MaxSum3NonOverlappingSubArrays {

	public static void main(String[] args) {
		
	}
	
	public static void solution(int[] arr, int k) {
		for(int i = 1; i < arr.length ;i++) {
			arr[i] += arr[i - 1];
		}
		
		int[] leftPos = new int[arr.length - 3 * k + 1];
		int[] rightPos = new int[arr.length - 3 * k + 1];
		
		int sum = 0;
		int max = arr[k - 1];
		for(int i = 1 ; i < arr.length - 3 * k + 1; i++) {
			sum = arr[i + k - 1] - arr[i - 1];
			if(sum > max) {
				max = sum;
				leftPos[i] = i;
			}else{
				leftPos[i] = leftPos[i - 1];
			}
		}
		
		sum = 0 ;
		max = 0;
		for(int i = arr.length - k; i >= 2 * k; i--) {
			sum = arr[i + k - 1] - arr[i - 1];
			if(sum > max) {
				rightPos[i - 2 * k] = i;
				max = sum;
			}else {
				rightPos[i - 2 * k] = rightPos[i - 2 * k + 1];
			}
		}
		
		max = 0;
		int[] ans = new int[3];
		for(int i = k; i <= arr.length - 2 * k; i++) {
			int l = leftPos[i - k];
			int r = rightPos[i - k];
			if(l > 0) {
				sum += arr[l + k - 1] - arr[l - 1];
			}
			sum += arr[i + k - 1] - arr[i - 1];
			sum += arr[r + k - 1] - arr[r - 1];
			if(sum > max) {
				max = sum;
				ans[0] = l;
				ans[1] = i;
				ans[2] = r;
			}
		}
		System.out.println(ans);
	}

}
