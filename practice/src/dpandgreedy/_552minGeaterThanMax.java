package dpandgreedy;

public class _552minGeaterThanMax {

	public static void main(String[] args) {
		int arr[] = {4, 5, 100, 9, 10, 11, 12, 15, 200}; 
        int n = arr.length; 
        solution(arr,n);
	}

	private static void solution(int[] arr, int n) {
		int len = 0;
		for(int i = 0 ; i < n; i++) {
			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
			for(int j = i; j < n; j++) {
				int val = arr[j];
				min = Math.min(min, val);
				max = Math.max(max, val);
				if(2 * min <= max) {
					break;
				}
				len = Math.max(len, j - i + 1);
			}
		}
		System.out.println(n - len);
	}

}
