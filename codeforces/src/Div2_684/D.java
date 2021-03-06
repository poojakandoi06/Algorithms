package Div2_684;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class D {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			int m = s.nextInt();
			int k = s.nextInt();
			ArrayList<Integer>[] list = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				list[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < m; i++) {
				int u = s.nextInt() - 1;
				int v = s.nextInt() - 1;
				list[u].add(v);
				list[v].add(u);

			}
			HashSet<Integer> ll = new HashSet<Integer>();
			HashSet<Integer> ll2=new HashSet<Integer>();
			for (int i = 0; i < n; i++) {
				if (list[i].size() >= (k)) {
					ll.add(i);
				}
				if(list[i].size()>=(k-1)) {
					ll2.add(i);
				}
			}
//			System.out.println(ll.toString());
//			System.out.println(ll2.toString());
			int[] store=new int[n+100];
			findCliques(0, 1, k, list, store);
			if(store[k]!=0) {
				out.println(2);
				for(int i=1;i<=k;i++) {
					out.print((store[i])+" ");
				}
				out.println();
				continue;
			}
			
			if (ll.size() < k) {
				out.println(-1);
				continue;
			}
			else {
				HashSet<Integer> res=new HashSet<>();
				for(int i:ll) {
					int count=0;
					for(int j=0;j<list[i].size();j++) {
						
						if(!ll.contains(list[i].get(j))) {
							if(list[list[i].get(j)].size()<k) {
								continue;
							}
							else {
								ll.addAll(list[list[i].get(j)]);
								count++;
							}
						}
						else {
							count++;
						}
					}
					if(count>=k) {
						res.add(i);
					}
				}
				if(res.size()<k) {
					out.println(-1);
				}
				
				else {
					out.println(1+" "+res.size());
					
					for(int i:res) {
						out.print((i+1)+" ");
					}
					out.println();
				}
			}
		}

		out.close();
	}

	
	
	  
	
	  
	
	static boolean is_clique(int b,ArrayList<Integer>[] list, int[] store) 
	{ 
	   
	    for (int i = 1; i < b; i++)  
	    { 
	        for (int j = i + 1; j < b; j++) 
	  
	            if (!list[store[i]].contains(store[j])) 
	                return false; 
	    } 
	    return true;
	} 
	static void findCliques(int i, int l, int k,ArrayList<Integer>[] list, int[] store) 
	{ 
	    for (int j:list[i]) 
	  
	        if (list[j].size() >= k- 1) 
	        { 
	  
	            store[l] = j; 
	  
	            
	            if (is_clique(l + 1,list,store)) {
	  
	               
	                if (l < k) 
	  
	                    findCliques(j, l + 1, k,list,store); 
	  
	                else
	                    return ;
	            }
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
