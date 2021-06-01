	package Div2_669;
	
	import java.io.BufferedOutputStream;
	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.util.ArrayList;
	import java.util.StringTokenizer;
	
	public class A {
	
		public static void main(String[] args) {
			MyScanner s = new MyScanner();
			out = new PrintWriter(new BufferedOutputStream(System.out));
			
			int t=s.nextInt();
			StringBuilder ss=new StringBuilder();
			while(t-->0)
			{
				int n=s.nextInt();
				int[] a=new int[n];
				for(int i=0;i<n;i++) {
					a[i]=s.nextInt();
					
				}
				int c = 0;
				StringBuilder sb = new StringBuilder();
				for(int i=0;i<n;i+=2){
					if(a[i] != a[i+1]){
						if(a[i] == 1){
							sb.append(a[i+1]+" ");
						}else{
							sb.append(a[i]+" ");
						}
						c+=1;
					}else{
						c+=2;
						sb.append(a[i]+" ");
						sb.append(a[i+1]+" ");
					}
				}
				ss.append(c+"\n");
				ss.append(sb+"\n");
			}		System.out.println(ss.toString());
			
			
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
