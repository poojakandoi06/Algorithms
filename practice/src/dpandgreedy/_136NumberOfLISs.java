package dpandgreedy;

import java.util.Arrays;

public class _136NumberOfLISs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void solution(int[] arr, int n) {
		int[] len = new int[n];
		int[] count = new int[n];
		Arrays.fill(len, 1);
		Arrays.fill(count, 1);
		int maxLen = 0;
		int lisCount = 0;
		
		for(int i = 0 ; i < arr.length; i++) {
			for(int j = 0 ; j < i; j++) {
				if(arr[i] > arr[j]) {
					if(len[i] == len[j] + 1) {
						count[i] += count[j];
					}else if(len[i] < len[j] + 1) {
						len[i] = len[j] + 1;
						count[i] = count[j];
					}
				}
			}
			if(maxLen == len[i]) {
				lisCount += count[i];
			}else if(maxLen < len[i]) {
				maxLen = len[i];
				lisCount = count[i];
			}
		}
		
		System.out.println(lisCount);
	}

}
