package dp;

public class min_palindromic_cut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//n3
		//not solved using hashmap

	}
	//n3
    public static int palindromepartition(String str) {
    	int n=str.length();
    	int[][] cut=new int[n][n];
    	boolean[][] isPal=new boolean[n][n];
    	for(int i=0;i<n;i++) {
    		isPal[i][i]=true;
    		cut[i][i]=0;
    	}
    	for(int l=2;l<=n;l++) {
    		for(int i=0;i<=n-l;i++) {
    			int j=i+l-1;
    			if(l==2) {
    				isPal[i][j]=str.charAt(i)==str.charAt(j);
    			}
    			else {
    				isPal[i][j]=(str.charAt(i)==str.charAt(j) && isPal[i+1][j-1]);
    			}
    			if(isPal[i][j]==true)
    				cut[i][j]=0;
    			else {
    				cut[i][j]=Integer.MAX_VALUE;
    					for(int k=i;k<=j;k++) {
    						cut[i][j]=Math.min(cut[i][j],1+cut[i][k]+cut[k+1][j]);
    					}
    			}
    		}
    	}
    	return cut[0][n-1];
    }
    // n3 can be converted into n2 if we just calculate palindromic 2d array before
    public static int palpartitionoptimized(String str) {
    	int n=str.length();
    	int[] c=new int[n];
    	boolean[][] p=new boolean[n][n];
    	for(int i=0;i<n;i++) {
    		p[i][i]=true;
    	}
    	for(int l=2;l<=n;l++) {
    		for(int i=0;i<=n-l;i++) {
    			int j=i+l-1;
    			if(l==2)
    				p[i][j]=str.charAt(i)==str.charAt(j);
    			else
    				p[i][j]=str.charAt(i)==str.charAt(j) && p[i+1][j-1];
    		}
    	}
    	for(int i=0;i<n;i++) {
    		if(p[0][i]==true)
    			c[i]=0;
    		else {
    			c[i]=Integer.MAX_VALUE;
    			for(int j=0;j<i;j++) {
    				if(p[j+1][i]==true && 1+c[j]<c[i])
    					c[i]=1+c[j];
    			}
    		}
    	}
    	return c[n-1];
    	
    }
}
