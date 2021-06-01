package dp;

import java.util.Arrays;

public class max_overlapping_bridges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s= {8,1,4,3,5,2,6,7};
		int[] e= {1,2,3,4,5,6,7,8};
		System.out.println(max__Non_overlap_bridges(s, e));

	}
	public static class pair implements Comparable<pair>{
		int start;
		int end;
		public pair(int s, int e) {
			this.start=s;
			this.end=e;
		}
		@Override
		public int compareTo(pair o) {
			return this.start-o.start;
		}
		
	}
	public static int max__Non_overlap_bridges(int[] start, int[] end) {
		pair[] p=new pair[start.length];
		for(int i=0;i<p.length;i++) {
			p[i]=new pair(start[i],end[i]);
		}
		Arrays.sort(p);
		int[] dp=new int[p.length];
		Arrays.fill(dp,1);
		int max=1;
		for(int i=1;i<dp.length;i++) {
			for(int j=0;j<i;j++) {
				if(p[i].end>p[j].end && dp[i]<dp[j]+1) {
					dp[i]=dp[j]+1;
					if(dp[i]>max)
						max=dp[i];
				}
					
			}
		}
		return max;
		
		
	}

}
