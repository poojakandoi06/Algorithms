package Div2_669;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {
	public static class SegmentTree {
		public long[] tree;
		public long NONE;
		int n;

		public SegmentTree(int[] arr,long none) {
			this.n = arr.length;
			this.tree = new long[4 * n + 1];
			this.NONE = none; // set this manually, Long.MAX_VALUE for min-segtree, Long.MIN-VALUE for
							// max-segTree, and 0 for sum segTree or xor segtree etc.
		}

		public long merge(long a, long b) {
			return a + b;
		}

		public void update(int arrindex, long val) {
			update(0, 0, n - 1, arrindex, val);
		}

		public void update(int treeindex, int lo, int hi, int arrindex, long val) {
			if (lo == hi) {
				tree[treeindex] = val;
				return;
			}
			int mid = lo + (hi - lo) / 2;
			if (arrindex > mid) {
				update(2 * treeindex + 2, mid + 1, hi, arrindex, val);
			} else if (arrindex <= mid) {
				update(2 * treeindex + 1, lo, mid, arrindex, val);
			}
			tree[treeindex] = merge(tree[treeindex * 2 + 1], tree[treeindex * 2 + 2]);

		}

		public long query(int i, int j) {
			return query(0, 0, n - 1, i, j);
		}

		public long query(int treeindex, int lo, int hi, int i, int j) {
			if (lo > j || hi < i) {
				return NONE;
			}
			if (i <= lo && j <= hi) {
				return tree[treeindex];
			}
			int mid = lo + (hi - lo) / 2;
			if (i > mid) {
				return query(2 * treeindex + 2, mid + 1, hi, i, j);
			} else if (j <= mid) {
				return query(2 * treeindex + 1, lo, mid, i, j);
			}
			long leftquery = query(2 * treeindex + 1, lo, mid, i, mid);
			long rightquery = query(2 * treeindex + 2, mid + 1, hi, mid + 1, j);

			return merge(leftquery, rightquery);

		}

		

	}

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int n=s.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=s.nextInt();
		}
		SegmentTree segmax=new SegmentTree(arr, Integer.MIN_VALUE);
		SegmentTree segmin=new SegmentTree(arr, Integer.MAX_VALUE);
		int count=0;
		int start=0;
		int i=1;
		while(start<(n-1)) {
			
			while(arr[i]<arr[start]) {
				i++;
			}
			count++;
			start=i;
			while(arr[i]>arr[start]) {
				
			}
			start
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
