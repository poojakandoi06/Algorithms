package CHLG2020;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PATTE1 {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t=s.nextInt();
		while(t-->0) {
			int n=s.nextInt();
//			int[][] arr=new int[4][n];
//			int next=2*1+2;
//			int prev=1;
//			for(int j=0;j<n;j++) {
//				for(int i=0;i<4;i++) {
//					if(i==2)
//						arr[i][j]=next;
//					else
//					arr[i][j]=prev++;
//				}
//				prev=next;
//				next=next*2+2;
//			}
//			for(int i=0;i<4;i++) {
//				for(int j=0;j<n;j++) {
//					out.print(arr[i][j]+" ");
//				}
//				out.println();
//			}
			for(int i=0;i<4;i++) {
				int nn=0;
				if(i==0)
					nn=1;
				else if(i==1)
					nn=2;
				else if(i==3)
					nn=3;
				else if(i==2)
					nn=4;
				for(int j=0;j<n;j++) {
					if(j==n-1)
						out.print(nn);
						else
						out.print(nn+" ");
					
					if(i==0) {
						nn=nn*2+2;
					}
					else if(i==1) {
						nn=nn*2+1;
					}
					else if(i==2) {
						nn=nn*2+2;
					}
					else {
						nn=nn*2;
					}
				}
				out.println();
			}
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
	public static class FastScanner {
		BufferedReader br;
		StringTokenizer st;
		
		public FastScanner(String s) {
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String nextToken() {
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
			return Integer.parseInt(nextToken());
		}
		
		long nextLong() {
			return Long.parseLong(nextToken());
		}
		
		double nextDouble() {
			return Double.parseDouble(nextToken());
		}

	}

}
