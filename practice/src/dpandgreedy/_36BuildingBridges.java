package dpandgreedy;

import java.util.*;

public class _36BuildingBridges {

	public static class pair implements Comparable<pair>{
		int nc;
		int sc;
		
		@Override
		public int compareTo(pair o) {
			if(this.sc > o.sc) {
				return 1;
			}else if(this.sc < o.sc) {
				return -1;
			}else {
				if(this.nc > o.nc) {
					return 1;
				}else if(this.nc < o.nc) {
					return -1;
				}else {
					return 0;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		pair[] arr = new pair[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new pair();
			arr[i].nc = scn.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arr[i].sc = scn.nextInt();
		}
		
		Arrays.sort(arr);
		
		int[] lis = new int[n];
		int ans = 0;
		lis[0] = 1;
		for(int i = 1 ; i < n; i++) {
			for(int j = 0 ; j < i; j++) {
				if(arr[i].nc > arr[j].nc) {
					if(lis[j] > lis[i]) {
						lis[i] = lis[j];
					}
				}
			}
			lis[i] += 1;
			ans = Math.max(ans, lis[i]);
		}
		System.out.println(ans);
	}

}
