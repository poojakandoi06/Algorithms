package DP;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class INVCNT {
	
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t=s.nextInt();
		String ss=s.nextLine();
		while(t-->0) {
			int n=s.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=s.nextInt();
			}
			 ss=s.nextLine();
			long count=0;
			int[] bit=new int[10000000+5];
			for(int i=n-1;i>=0;i--) {
				count+=get(bit,arr[i]-1);
				update(bit,arr[i]);
			}
			System.out.println(count);
			
		}
		
		
		out.close();
	}
	public static int get(int[] bit, int i) {
		int count=0;
		while(i>0) {
			count+=bit[i];
			i-=i&-i;
		}
		return count;
	}
	public static void update(int[] bit, int i) {
		
		while(i<bit.length) {
			bit[i]++;
			i+=i&-i;
		}
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
