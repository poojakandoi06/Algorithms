import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int n = s.nextInt();
		int q = s.nextInt();
		int[] arr = new int[n];
		SegmentTree st = new SegmentTree(arr);
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
			st.update(i, arr[i]);
		}
		
//		for(int i=0;i<st.tree.length;i++) {
//			System.out.print(st.tree[i]+" ");
//		}
		System.out.println();
		while (q-- > 0) {
			int l = s.nextInt() - 1;
			int r = s.nextInt() - 1;
			out.println(st.query(l, r));
		}

		out.close();
	}

	public static class SegmentTree {
		public long[] tree;
		public long NONE;
		int n;

		public SegmentTree(int[] arr) {
			this.n = arr.length;
			this.tree = new long[4 * n + 1];
			this.NONE = Long.MAX_VALUE; // set this manually, Long.MAX_VALUE for min-segtree, Long.MIN-VALUE for
							// max-segTree, and 0 for sum segTree or xor segtree etc.
		}

		public long merge(long a, long b) {
			return Math.min(a, b);
		}

		public void update(int arrindex, long val) {
			update(0, 0, n - 1, arrindex, val);
		}

		public void update(int treeindex, int lo, int hi, int arrindex, long val) {
			if (lo == hi) {
				tree[treeindex] = val;
				return;
			}
			int mid = (hi + lo) / 2;
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
			if (i <= lo && j >= hi) {
				return tree[treeindex];
			}
			int mid =  (hi + lo) / 2;
			//System.out.println(mid+" "+i+" "+j);
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
