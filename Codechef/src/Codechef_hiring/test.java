package Codechef_hiring;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class test {

	public static void main(String[] args) {
		FastScanner s = new FastScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			int q = s.nextInt();
			int r = s.nextInt() - 1;
			int[] parent=new int[n];
			int[] level=new int[n];
			level[r]=0;
			parent[r]=-1;
			HashMap<Integer, Long>[] list = new HashMap[n];
			for (int i = 0; i < n; i++)
				list[i] = new HashMap<Integer, Long>();
			for (int i = 0; i < n - 1; i++) {
				int a = s.nextInt() - 1;
				int b = s.nextInt() - 1;
				long w = s.nextLong();
				list[a].put(b, w);
				list[b].put(a, w);
			}
			dfs(r, list,parent,level);
//			for(int i=0;i<n;i++)
//				System.out.print(parent[i]+" ");
//			System.out.println();
//			for(int i=0;i<n;i++) {
//				System.out.println(list[i].toString());
//			}
			for (int i = 0; i < q; i++) {
				int u = s.nextInt() - 1;
				int v = s.nextInt() - 1;
				if(u==v)
					out.println(0);
				else if(list[u].containsKey(v))
				out.println(list[u].get(v));
				else if(list[v].containsKey(u))
					out.println(list[v].get(u));
				else {
					int a=u;
					int b=v;
					while(level[a]>level[b]) {
						a=parent[a];
					}
					while(level[b]>level[a]) {
						b=parent[b];
					}
					while(parent[a]!=parent[b]) {
						a=parent[a];
						b=parent[b];
					}
					int lca=parent[a];
				out.println(list[lca].get(u)+list[lca].get(v));
				}

			}
		}
		out.close();
	}
	

	public static HashMap<Integer, Long> dfs(int root, HashMap<Integer, Long>[] list,
			int[] parent, int[] level) {
		HashMap<Integer, Long> map = new HashMap<Integer, Long>();
		for (int i : list[root].keySet()) {
			if (i == parent[root])
				continue;
			parent[i]=root;
			level[i]=level[root]+1;
			HashMap<Integer, Long> map2 = dfs(i, list,  parent, level);
			if(map2!=null) {
			for (int j : map2.keySet()) {
				map.put(j, map2.get(j) + list[root].get(i));
			}
			map.put(i,list[root].get(i));
			}
		}
		//System.out.println(map.toString());
		list[root] = new HashMap<Integer,Long>(map);
		
		return map;

	}

	public static int dj(int start, int end, ArrayList<int[]>[] list) {
		HashSet<Integer> done = new HashSet<>();
		done.add(start);
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { start, 0 });
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int[] pop = q.poll();
				if (pop[0] == end)
					return pop[1];
				for (int i = 0; i < list[pop[0]].size(); i++) {
					int v = list[pop[0]].get(i)[0];
					int w = list[pop[0]].get(i)[1];
					if (!done.contains(v)) {
						q.add(new int[] { v, pop[1] + w });
						done.add(v);
					}
				}
			}

		}
		return -1;
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
