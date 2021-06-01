package Div2_689;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class C {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t=s.nextInt();
		while(t-->0) {
			int n=s.nextInt();
			int m=s.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++)
				arr[i]=s.nextInt();
			double[] p=new double[n];
			Arrays.fill(p, 1);
			for(int i=0;i<m;i++) {
				int idx=s.nextInt()-1;
				double per=s.nextDouble();
				p[idx]*=(1-per);
			}
			int index=-1;
			for(int i=n-1;i>=0;i--) {
				if(arr[i]!=(i+1)) {
					index=i;
					break;
				}
			}
					
			if(index==-1) {
				out.println("1.0");
			}
			else {
				double ans=1;
				for(int i=index;i<n;i++) {
					ans*=p[i];
				}
				out.println(1-ans);
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

}
