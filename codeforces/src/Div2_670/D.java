package Div2_670;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
			int n = s.nextInt();
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextLong();
			}
			long sumpos = 0; // increasing
			long[] diff=new long[n-1];
			for (int i = 1; i < n; i++) {
				diff[i-1]=arr[i]-arr[i-1];
				if (diff[i-1]>0) {
					sumpos+=diff[i-1];
				}
					
			}
			// considering 1st value of c as 0
			long bfinal=arr[0]+sumpos;
			if(bfinal>0) {
				System.out.println((bfinal+1)/2);
			}
			else {
				System.out.println(bfinal/2);
			}
			int q=s.nextInt();
			while(q-->0) {
				int l=s.nextInt()-1;
				int r=s.nextInt()-1;
				long x=s.nextLong();
				if(l>0) {
					if(diff[l-1]>0) {
						sumpos-=diff[l-1];
					}
					diff[l-1]+=x;
					if(diff[l-1]>0) {
						sumpos+=diff[l-1];
					}
				}
				if(r<n-1) {
					if(diff[r]>0)
						sumpos-=diff[r];
					diff[r]-=x;
					if(diff[r]>0)
						sumpos+=diff[r];
				}
				if(l==0) {
					arr[0]+=x;
				}
				bfinal=arr[0]+sumpos;
				if(bfinal>0) {
					System.out.println((bfinal+1)/2);
				}
				else {
					System.out.println(bfinal/2);
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
