package Lunchtime_Aug;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class ELOMAX {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int t = s.nextInt();
			StringBuilder sb = new StringBuilder();
			while (t-- > 0) {
				int n = s.nextInt();
				int m = s.nextInt();
				int[] sr = new int[n];
				for (int i = 0; i < n; i++)
					sr[i] = s.nextInt();
				int[][] change = new int[n][m];
				int[] max = new int[n];
				int[] maxm = new int[n];
				for (int i = 0; i < n; i++) {
					int prev = sr[i];
					for (int j = 0; j < m; j++) {
						 int ch = s.nextInt();
						change[i][j] = prev + ch;
						prev = change[i][j];
						if (change[i][j] > max[i]) {
							max[i] = change[i][j];
							maxm[i] = j;
						}
					}
				}
				int[][] rank = new int[n][m];
				for(int i=0;i<m;i++) {
					PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->(b[2]-a[2]));
					for(int j=0;j<n;j++) {
						pq.add(new int[] {j,i,change[j][i]});
					}
					int maxx =pq.peek()[2],count=1,rnk=1;

			        while(pq.size()>0){
			          int[] ele = pq.remove();
			          int rating = ele[2];

			          if(rating==maxx){
			            rank[ele[0]][ele[1]]=rnk;
			          }else{
			            rank[ele[0]][ele[1]]=count;
			            rnk=count;
			            maxx=rating;
			          }
			          count++;
			        }
					
				}
				
				int res = 0;
				int[] maxrank = new int[n];
				for (int i = 0; i < n; i++) {
					int r = Integer.MAX_VALUE;
					for (int j = 0; j < m; j++) {
						if (rank[i][j] < r) {
							r = rank[i][j];
							maxrank[i] = j;
						}
					}
				}

				for(int i=0;i<n;i++) {
					for(int j=0;j<m;j++) {
						System.out.print(rank[i][j]+" ");
					}
					System.out.println();
				}
				for (int i = 0; i < n; i++) {
					if (maxm[i] != maxrank[i])
						res++;
				}
				sb.append(res);
				sb.append("\n");
				
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
			System.out.println(e);
			return;
		}

	}
	
}
