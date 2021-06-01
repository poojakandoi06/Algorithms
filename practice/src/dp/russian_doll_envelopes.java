package dp;

import java.util.Arrays;

public class russian_doll_envelopes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static class pair implements Comparable<pair> {
		int w;
		int h;

		public pair(int w, int h) {
			this.w = w;
			this.h = h;
		}

		@Override
		public int compareTo(pair o) {
			return this.w - o.w;
		}
	}

	public static int RDenvelopes(int[] width, int[] height) {
		pair[] p = new pair[width.length];
		for (int i = 0; i < p.length; i++) {
			p[i] = new pair(width[i], height[i]);
		}
		Arrays.sort(p);
		int[] dp=new int[p.length];
		int max=1;
		Arrays.fill(dp,1);
		for(int i=1;i<p.length;i++) {
			for(int j=0;j<i;j++) {
				if(p[i].h>p[j].h && dp[i]<dp[j]+1) {
					dp[i]=dp[j]+1;
					if(dp[i]>max)
						max=dp[i];
				}
			}
		}
		return max;
	}

}
