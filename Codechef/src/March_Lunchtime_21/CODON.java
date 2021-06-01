package March_Lunchtime_21;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class CODON {
	
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t=s.nextInt();
		while(t-->0) {
			int n=s.nextInt();
			int m=s.nextInt();
			int l=s.nextInt();
			String str=s.next();
			String total=s.next();
			int[][] edge=new int[m][2];
			for(int i=0;i<m;i++) {
				edge[i][0]=s.nextInt()-1;
			}
			for(int i=0;i<m;i++) {
				edge[i][1]=s.nextInt()-1;
			}
			HashMap<Character,List<Integer>> map=new HashMap<>();
			for(int i=0;i<n;i++) {
				if(!map.containsKey(total.charAt(i))) {
					map.put(total.charAt(i),new ArrayList<Integer>());
				}
				map.get(total.charAt(i)).add(i);
			}
			//out.print(map.toString());
			int[][] graph=new int[n][n];
			for(int i=0;i<m;i++) {
				int u=edge[i][0];
				int v=edge[i][1];
				graph[u][v]++;
				graph[v][u]++;
			}
			int[][] dp=new int[n+3][n+3];
			for(int i=0;i<=n;i++)
				Arrays.fill(dp[i], -1);
		    long count=dfs(str,graph,0,map,-1,dp);
		    if(str.equals(new StringBuilder(str).reverse().toString()))
			count=(count+1)/2;
		    out.println((int)(count%1000000007));
		}
		
		out.close();
	}
	public static long dfs(String str, int[][] graph, int i,HashMap<Character,List<Integer>> map, int prev,int[][] dp) {
		if(i==str.length()) {
			return 1;
		}
		if(dp[i][prev+1]!=-1)
			return dp[i][prev+1];
		int count=0;
		List<Integer> index=map.get(str.charAt(i));
		for(int j:index) {
			if(j==prev)
				continue;
			if(prev==-1) {
				count+=dfs(str,graph,i+1,map,j,dp);
				count=count%1000000007;
			}
			else {
				count+=graph[prev][j]*dfs(str,graph,i+1,map,j,dp);
				count=count%1000000007;
			}
		}
		return dp[i][prev+1]=count%1000000007;
		
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
