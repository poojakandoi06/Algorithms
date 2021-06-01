import java.util.Scanner;

public class SegmentTree2D {
	public long[][] st;
	public long[][] matrix;
	public int n;
	public int m;
	public int NULL;

	public SegmentTree2D(long[][] mat) {
		this.NULL = -100000;
		this.matrix = mat;
		this.n = mat.length;
		this.m = mat[0].length;
		this.st = new long[4 * n + 1][4 * m + 1];
		build2D(0, 0, n - 1);
	}
	public long merge(long a , long b) {
		return a+b;
	}

	private void build2D(int index, int L, int R) {
		if(L==R) {
			build1D(index,matrix[L],0,0,m-1);
		}
		else {
			int mid=(L+R)/2;
			build2D(2*index+1,L,mid); 
			build2D(2*index+2,mid+1,R); 
			for(int i=0;i<=4*m;i++) {
				st[index][i]=merge(st[2*index+1][i],st[2*index+2][i]);
			}
		}
	}
	private void build1D(int ind, long[] nums,int index, int l, int r) {   
		if(l==r) {
			st[ind][index]=nums[l];
		}
		else {
			int mid=(l+r)/2;
			build1D(ind,nums,2*index+1,l,mid);                           
			build1D(ind, nums, 2*index+2, mid+1, r);                      
			st[ind][index]=merge(st[ind][2*index+1],st[ind][2*index+2]);  
		}
	}
	public long query(int x1, int y1, int x2, int y2) {
		return query2D(0,0,n-1,x1,y1,x2,y2);
	}
	private long query2D(int index,int L, int R, int x1, int y1, int x2, int y2) {
		if(L > x2 || R < x1)
		      return NULL;

		    if(L >= x1 && R <= x2)
		      return query(index, 0, 0, m - 1, y1, y2);

		    int mid = (L + R) / 2;

		    long left = query2D(2*index+1, L, mid, x1, y1, x2, y2);
		    long right = query2D(2*index + 2, mid + 1, R, x1, y1, x2, y2);

		    if(left == NULL)
		      return right;
		    if(right == NULL)
		      return left;
		    
		    return merge(left,right);
	}
	private long query(int ind, int index, int L, int R, int y1, int y2) {
	    if (y1 > R || y2 < L)
	      return NULL;
	    if (L>=y1 && R<=y2) {
	      return st[ind][index];
	    }
	    int mid = (L + R) / 2;
	    long left = query(ind, 2*index+1, L, mid, y1, y2);
	    long right = query(ind, 2*index + 2, mid + 1, R, y1, y2);
	    if(left == NULL)
	      return right;
	    if(right == NULL)
	      return left;
	    return merge(left,right);
	  }
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		long[][] arr=new long[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j]=s.nextLong();
			}
		}
		SegmentTree2D segt=new SegmentTree2D(arr);
		
		long val=segt.query(0,0,2,0);
		System.out.println(val);
	}
	

}
