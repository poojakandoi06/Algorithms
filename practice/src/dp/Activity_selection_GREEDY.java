package dp;

import java.util.Arrays;

public class Activity_selection_GREEDY {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//can be done using non-overlapping bridges problem
		int[] s= {1,3,0,5,8,5};
		int[] e= {2,4,6,7,9,9};
		System.out.println(activitySelection(s, e));

	}
	public static class pair implements Comparable<pair>{
		int s;
		int e;
		public pair(int s, int e) {
			this.s=s;
			this.e=e;
		}
		@Override
		public int compareTo(pair o) {
			return this.e-o.e;
		}
	}
	public static int activitySelection(int[] start, int[] end) {
		pair[] p=new pair[start.length];
		for(int i=0;i<p.length;i++)
			p[i]=new pair(start[i],end[i]);
		Arrays.sort(p);
		String str=p[0].e+" ";
		int max=1;
		int endindex=p[0].e;
		for(int i=1;i<p.length;i++) {
			if(p[i].s>endindex) {
				max++;
				str+=p[i].e+" ";
				endindex=p[i].e;
			}
			else
				continue;
		}
		System.out.println(str);
		return max;
	}

}
