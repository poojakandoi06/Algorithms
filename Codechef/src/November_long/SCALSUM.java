package November_long;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SCALSUM {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int n=s.nextInt();
		int q=s.nextInt();
		long[] f=new long[n];
		for(int i=0;i<n;i++) {
			f[i]=s.nextLong();
		}
		ArrayList<Integer>[] list=new ArrayList[n];
		for(int i=0;i<n;i++) {
			list[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<n-1;i++) {
			int u=s.nextInt()-1;
			int v=s.nextInt()-1;
			list[u].add(v);
			list[v].add(u);
		}
		int[] parent=new int[n];
		long[] direct=new long[n];
		
		long mod=(long)Math.pow(2,32);
		dfs(0,parent,list,-1);
		dfs2(0,list,direct,f,parent);
		while(q-->0) {
			int u=s.nextInt()-1;
			int v=s.nextInt()-1;
			long res=0;
			while(u!=v) {
				res=(res%mod+f[u]*f[v]%mod)%mod;
				u=parent[u];
				v=parent[v];
			}
			res=(res%mod+direct[u]%mod)%mod;
			out.println(res);
		}
		
		out.close();
	}
	public static void dfs2(int v, ArrayList<Integer>[] list, long[] direct,long[] f, int[] p) {
		long mod=(long)Math.pow(2,32);
		if(v!=0)
		direct[v]=(direct[p[v]]%mod+f[v]*f[v]%mod)%mod;
		else
			direct[v]=f[v]*f[v]%mod;
		for(int i=0;i<list[v].size();i++) {
			if(list[v].get(i)==p[v])
				continue;
			int u=list[v].get(i);
			dfs2(u,list,direct,f,p);
			
		}
	}
	public static void dfs(int vertex, int[] parent,ArrayList<Integer>[] list, int p) {
		parent[vertex]=p;
		for(int i=0;i<list[vertex].size();i++) {
			if(list[vertex].get(i)==p)
				continue;
			dfs(list[vertex].get(i),parent,list,vertex);
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
