package Div3_667;

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
		int t = s.nextInt();
		while (t-- > 0) {
			int n=s.nextInt();
			int x=s.nextInt();
			int y=s.nextInt();
			if(x==y) {
				for(int i=0;i<n;i++) {
					System.out.print(x+" ");
				}
				System.out.println();
				
			}
			else {
				for(int d=1;d<=y;d++) {
					if((y-x)%d==0 && (y-x)/d+1<=n) {
						for(int num=x;num<=y;num+=d) {
							System.out.print(num+" ");
						}
						n-=(y-x)/d+1;
						while(n>0) {
							if(x>d) {
								x-=d;
								System.out.print(x+" ");
							}
							else
							{
								y+=d;
								System.out.print(y+" ");
							}
							n--;
						}
						System.out.println();
						break;
						
					}
				}
				
				
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
