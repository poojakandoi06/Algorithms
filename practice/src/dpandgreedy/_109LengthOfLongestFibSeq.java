package dpandgreedy;

import java.util.HashSet;

public class _109LengthOfLongestFibSeq {

	public static void main(String[] args) {
		int[] arr = {1,3,7,11,12,14,18};
		solution(arr);
	}
	
	public static void solution(int[] arr) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0 ; i < arr.length ; i++) {
			set.add(arr[i]);
		}
		
		int maxLen = 0, x, y;
		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = i + 1; j < arr.length ; j++) {
				x = arr[j];
				y = arr[i] + arr[j];
				int length = 2;
				while(set.contains(y) && y <= arr[arr.length - 1]) {
					length++;
					int z = x + y;
					x = y;
					y = z;
					
				}
				maxLen = Math.max(maxLen, length);
			}
		}
		System.out.println(maxLen >= 3 ? maxLen : 0);
	}

}
