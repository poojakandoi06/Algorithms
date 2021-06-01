package september_LongChallenge;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EQDIV {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int k=s.nextInt();
		int t=s.nextInt();
		while(t-->0) {
			int n=s.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=(int)Math.pow(i+1, k);
			}
			int[] dp=new int[n];
			Arrays.fill(dp, -1);
			int val=dfs(0,arr,dp);
			System.out.println(val);
			for(int i=0;i<n;i++) {
				if(dp[i]==1)
					System.out.print(1);
				else
				System.out.print(0);
			}
			System.out.println();
			
		}
		
		out.close();
	}
	public static int dfs(int i, int[] arr,int[] dp) {
		if(i==arr.length) {
			int sum=0;
			for(int j=0;j<arr.length;j++) {
				sum+=arr[j]*dp[j];
			}
			return Math.abs(sum);
		}
		
		dp[i]=1;
		int v1=dfs(i+1,arr,dp);
		dp[i]=-1;
		int v2=dfs(i+1,arr,dp);
		if(v1<v2) {
			dp[i]=1;
			return v1;
		}
		else {
			dp[i]=-1;
			return v2;
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
