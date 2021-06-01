package Lunchtime_Nov_div1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CIRCLEAT {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t=s.nextInt();
		while(t-->0) {
			int n=s.nextInt();
			long[] arr=new long[n];
			for(int i=0;i<n;i++) {
				arr[i]=s.nextLong();
			}
			PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->(b[1]-a[1]));
			long min=arr[0];
			long happy=arr[0];
			pq.add(new int[] {1,(int)arr[1]});
			pq.add(new int[] {n-1,(int)arr[n-1]});
			HashSet<Integer> set=new HashSet<>();
			set.add(0);
			set.add(1);
			set.add(n-1);
			while(pq.size()>0) {
				int[] poll=pq.poll();
				//System.out.println(poll[0]);
				happy=happy+poll[1];
				min=Math.min(happy, min);
				int left=poll[0]-1;
				int right=poll[0]+1;
				if(left<0)left+=n;
				if(right>=n)right-=n;
				if(!set.contains(left)) {
					pq.add(new int[] {left,(int)arr[left]});
					set.add(left);
				}
				if(!set.contains(right)) {
					pq.add(new int[] {right,(int)arr[right]});
					set.add(right);
				}
			}
			out.println(min);
		}
		
		
		out.close();
	}
	
	public static PrintWriter out;
	
	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
		
	}
	

	}


