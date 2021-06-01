	package september_LongChallenge;
	
	import java.io.BufferedOutputStream;
	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.util.StringTokenizer;
	
	public class ADAMAT {
	
		public static void main(String[] args) {
			MyScanner s = new MyScanner();
			out = new PrintWriter(new BufferedOutputStream(System.out));
			int t=s.nextInt();
			while(t-->0) {
				int n=s.nextInt();
				int[][] arr=new int[n][n];
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++)
						arr[i][j]=s.nextInt();
				}
				int  count=0;
				for(int i=n-1;i>=1;i--) {
					//System.out.println(arr[0][i]+" "+count);
					if(count%2==0) {
						if(arr[0][i]==(i+1)) {
							continue;
						}
						else {
							count++;
						}
					}
					else {
						if(arr[0][i]==(i+1)) {
							count++;
						}
						else {
							continue;
						}
					}
				}
				System.out.println(count);
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
