package Div2_669;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int n=s.nextInt();
		int[] a = new int[n];
		 
		if(n == 1)
		{
			System.out.println("! 1");
			System.out.flush();
			return;
		}
 
		int i=0, j=1;
 
		for(int w=0; w<2*n; w++)
		{
			System.out.println("? " + (i+1) + " " + (j+1));
			System.out.flush();
			int xi = s.nextInt();
 
			System.out.println("? " + (j+1) + " " + (i+1));
			System.out.flush();
			int xj = s.nextInt();
 
			if(xi > xj)
			{
				a[i] = xi;
				while(i<n && a[i] != 0) i++;
				if(i == j) i++;
			}
			else
			{
				a[j] = xj;
				while(j<n && a[j] != 0) j++;
				if(i == j) j++;
			}
 
			if(i==j || i==n || j==n) break;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("! ");
 
		for(int w=0; w<n; w++)
		{
			if(a[w] == 0)
			{
				a[w] = n;
			}
			sb.append(a[w]).append(" ");
		}
 
		System.out.println(sb.toString().trim());
		System.out.flush();
		
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
