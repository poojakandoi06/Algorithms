
public class LazyST {
		public long[] tree;
		public long[] lazy;
		public int n;
		public long NONE;
		
		public LazyST(int n) {
			this.n=n;
			this.tree=new long[4*n+1];
			this.lazy=new long[4*n+1];
			this.NONE=0L; // set none on the basis of problem
		}
		// update nums[updateL---updateR]+=val
		public void add(int updateL, int updateR, long val) {
			add(0,0,n-1,updateL,updateR,val);
		}
		private void add(int treeindex, int l, int r, int updateL, int updateR, long val) {
			push(treeindex,l,r);
			if(updateL<=l && updateR>=r ) {
				// fully contained
				lazy[treeindex]+=val;
				push(treeindex,l,r);
				return;
			}
			else if(l>updateR || r<updateL) {
				// not contained at all
				return;
			}
			add(2*treeindex+1,l,(l+r)/2,updateL,updateR,val);
			add(2*treeindex+2,(l+r)/2+1,r,updateL,updateR,val);
			tree[treeindex]=merge(tree[2*treeindex+1],tree[2*treeindex+2]);
			
		}
		public long query(int lq, int rq) {
			return query(0,0,n-1,lq,rq);
		}
		public long query(int treeindex, int l, int r, int lq, int rq) {
			push(treeindex,l,r);
			if(lq<=l && rq>=r) {
				return tree[treeindex];
			}
			else if(r<lq || l>rq)
				return NONE;
			else {
				return merge(query(2*treeindex+1,l,(l+r)/2,lq,rq),query(2*treeindex+2,(l+r)/2+1,r,lq,rq));
			}
		}
		public void push(int index,int l, int r) {
			tree[index]+=operation(lazy[index],l,r);
			if(l<r) {
				lazy[2*index+1]+=lazy[index];
				lazy[2*index+2]+=lazy[index];
			}
			lazy[index]=0L;
		}
		public long operation(long val, int l ,int r) {
			return (r-l+1)*val;
		}
		public long merge(long a, long b) {
			return a+b; // return Math.min(a,b) for min segtree and max for max segtree
		}
		
		public static void main(String[] args) {
			int[] arr=new int[] {1,2,3,4,5};
			LazyST lst=new LazyST(arr.length);
			for(int i=0;i<arr.length;i++) {
				lst.add(i, i, arr[i]);
			}
			for(int i=0;i<arr.length-2;i++) {
				System.out.println(lst.query(i, i+2));
			}
		}
	

}
