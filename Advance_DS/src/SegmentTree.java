
public class SegmentTree {
	public long[] tree;
	public long NONE;
	int n;

	public SegmentTree(int[] arr) {
		this.n = arr.length;
		this.tree = new long[4 * n + 1];
		this.NONE = 0L; // set this manually, Long.MAX_VALUE for min-segtree, Long.MIN-VALUE for
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
