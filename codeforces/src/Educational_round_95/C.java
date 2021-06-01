package Educational_round_95;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t=s.nextInt();
		while(t-->0) {
			int n=s.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=s.nextInt();
			}
			int[][] dp=new int[n][2];
			for(int i=0;i<n;i++)
				Arrays.fill(dp[i], -1);
			int val=dfs(0,arr,0,dp);
			System.out.println(val);
		}
		
		out.close();
	}
	public static int dfs(int i, int[] arr, int turn,int[][] dp) {
		if(i==arr.length)
			return 0;
		if(dp[i][turn]!=-1)
			return dp[i][turn];
		int max=Integer.MAX_VALUE;
		if(turn==0) {
			if(i==arr.length-1) {
				max= arr[i]+dfs(i+1,arr,1-turn,dp);
			}
			else {
				max= Math.min(arr[i]+arr[i+1]+dfs(i+2,arr,1-turn,dp), arr[i]+dfs(i+1,arr,1-turn,dp));
			}
		}
		else {
			if(i==arr.length-1) {
				max= dfs(i+1,arr,1-turn,dp);
			}
			else {
				max= Math.min(dfs(i+2,arr,1-turn,dp), dfs(i+1,arr,1-turn,dp));
			}
		}
		return dp[i][turn]=max;
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
