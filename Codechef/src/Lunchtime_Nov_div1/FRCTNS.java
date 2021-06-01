package Lunchtime_Nov_div1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FRCTNS {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int n=s.nextInt();
		int count=0;
		for(int i=1;i<=n;i++) {
			for(int j=i+1;j<=n && j<=2*i+1;j++) {
				int x=i*(j+1);
				int y=j*(i+1);
				int gcd=gcd(x,y);
				x=x/gcd;
				y=y/gcd;
				if(x+1==y) {
					//System.out.println(i+" "+j);
					count++;
				}
			}
			
		}
		out.println(count);
		
		
		out.close();
	}
	
	public static int gcd(int a, int b) {
		if(b==0)
			return a;
		return gcd(b,a%b);
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


