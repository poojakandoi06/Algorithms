package Lunchtime_Nov_div1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ROOKPATH {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t=s.nextInt();
		while(t-->0) {
			int n=s.nextInt();
			int m=s.nextInt();
			int[][] arr=new int[n][n];
			ArrayList<Integer>[] row=new ArrayList[n];
			ArrayList<Integer>[] col=new ArrayList[n];
			for(int i=0;i<n;i++) {
				row[i]=new ArrayList<Integer>();
				col[i]=new ArrayList<Integer>();
			}
			
			for(int i=0;i<m;i++) {
				int x=s.nextInt();
				int y=s.nextInt();
				arr[x][y]=1;
				row[x].add(y);
				col[y].add(x);
			}
			for(int i=0;i<n;i++) {
				Collections.sort(row[i]);
				Collections.sort(col[i]);
			}
			
			int[] start=null;
			int[] end=null;
			for(int i=0;i<n;i++) {
				if(row[i].size()==1) {
					if(start==null)
						start=new int[] {i,row[i].get(0)};
					else
						end=new int[] {i,row[i].get(0)};
				}
				if(col[i].size()==1) {
					if(start==null)
						start=new int[] {i,col[i].get(0)};
					else
						end=new int[] {i,col[i].get(0)};
				}
			}
			
			ArrayList<Integer> list=new ArrayList<Integer>();
			
				
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
