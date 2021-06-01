package Lunchtime_Nov_div1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class GASOLINE {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t=s.nextInt();
		while(t-->0) {
			int n=s.nextInt();
			long[] f=new long[n];
			long[] c=new long[n];
			for(int i=0;i<n;i++)
				f[i]=s.nextLong();
			for(int i=0;i<n;i++)
				c[i]=s.nextLong();
			PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->(a[1]-b[1]));
			for(int i=0;i<n;i++) {
				pq.add(new int[] {i,(int)c[i]});
			}
			long cost=0;
			while(n>0) {
				int[] poll=pq.poll();
				long needed=Math.min(n,f[poll[0]]);
				cost+=(long)(needed*c[poll[0]]);
				n-=needed;
			}
			out.println(cost);
					
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


