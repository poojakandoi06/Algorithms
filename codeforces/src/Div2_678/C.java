package Div2_678;

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
//		long a=65484806400L;
//		long b=a%1000000007;
//		for(int i=1;i<=116;i++){
//			b=(b*i)%1000000007;
//		}
//		System.out.println(b);
		int n=s.nextInt();
		int x=s.nextInt();
		int pos=s.nextInt();
		long prod=1;
		int left=x-1;
		int right=n-x;
		int h=1;
		int l=0;
		int r=n;
		int middle=(l+r)/2;
		while(middle!=pos) {
			if(middle>pos) {
				//System.out.println(middle+" "+right);
				prod*=right;
				right--;
				r=middle;
			}
			else {
				//System.out.println(middle+" "+left);
				prod*=left;
				left--;
				l=middle+1;
			}
			
			prod=prod%1000000007;
			h++;
			middle=(l+r)/2;
		}
		int rem=n-h;
		//System.out.println(rem);
		for(int i=1;i<=rem;i++) {
			prod=(prod*i)%1000000007;
		}
		System.out.println(prod);
		
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
