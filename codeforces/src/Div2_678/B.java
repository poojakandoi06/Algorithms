package Div2_678;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t=s.nextInt();
		while(t-->0) {
			int n=s.nextInt();
			if(prime(n)) {
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						System.out.print("1 ");
					}
					System.out.println();
				}
			}
			else {
				int rem=99991-(n-1);
				while(prime(rem)) {
					rem=rem-(n-1);
				}
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(i==j)
						System.out.print(rem+" ");
						else {
							System.out.print(1+" ");
						}
					}
					System.out.println();
				}
			}
		}
		
		out.close();
	}
	public static boolean prime(int n) {
		if(n%2==0)
			return false;
		for(int i=3;i*i<=n;i+=2) {
			if(n%i==0)
				return false;
		}
		return true;
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
