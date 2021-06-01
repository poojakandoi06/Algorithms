package dpandgreedy;
import java.util.*;

public class _71MaxSumAlternatingSubseq {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		solution(arr, n);
	}
	
	public static void solution(int[] arr, int n) {
		int[] dec = Arrays.copyOf(arr, arr.length);
		int[] inc = Arrays.copyOf(arr, arr.length);
		boolean firstDip = false;
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j < i; j++) {
				if(arr[j] > arr[i]) {
					dec[i] = Math.max(dec[i], inc[j] + arr[i]);
					firstDip = true;
				}else if(arr[j] < arr[i] && firstDip) {
					inc[i] = Math.max(inc[i], dec[j] + arr[i]);
				}
			}
		}
		int ans = Integer.MIN_VALUE;
		for(int i = 0 ; i < n; i++) {
			ans = Math.max(ans, Math.max(inc[i], dec[i]));
		}
		System.out.println(ans);
	}

}
