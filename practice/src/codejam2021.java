import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class codejam2021 {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t=s.nextInt();
		for(int k=1;k<=t;k++) {
			int m=s.nextInt();
			int n=s.nextInt();
			int p=s.nextInt();
			int[][] arr=new int[m+n][m+n];
			for(int i=0;i<m+n;i++) {
				String str=s.next();
				for(int j=0;j<m+n;j++) {
					if(str.charAt(j)=='Y') {
						arr[i][j]=1;
					}
					else
						arr[i][j]=0;
				}
			}
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<p;i++) {
				int a=s.nextInt()-1;
				int b=s.nextInt()-1;
				long[][] dp=new long[arr.length][arr.length];
				for(int j=0;j<dp.length;j++)
					Arrays.fill(dp[j], Integer.MAX_VALUE);
				long res=dfs(a,b,arr,m,n,dp);
				if(res>=Integer.MAX_VALUE)
					sb.append("-1");
				else
				sb.append(res);
				if(i<(p-1)) {
					sb.append(" ");
				}
				
			}
			out.println("Case #"+k+": "+sb.toString());
		}
		
		
		
		out.close();
	}
	


	public static long dfs(int a, int b, int[][] arr,int m, int n,long[][] dp) {
		if(arr[a][b]==1 || a==b)
			return 0;
		if(dp[a][b]!=Integer.MAX_VALUE) {
			return dp[a][b];
		}
		long max=Integer.MAX_VALUE;
		for(int i=0;i<m;i++) {
			if(arr[a][i]==1 && a!=i) {
				arr[a][i]=0;
				max=Math.min(max,1+dfs(i,b,arr,m,n,dp));
				arr[a][i]=1;
			}
		}
		return dp[a][b]=max;
		
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
