package binary_search;

public class medianOFTwoSortedArrrays_ofDIffSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 19, 21, 18, 25};

        
        System.out.println(median(x,y));

	}
	public static double median(int[] x, int[] y) {
		if(x.length>y.length)
			return median(y,x);
		
		int start=0;
		int end=x.length;
		while(start<=end) {
			int partitionx=(start+end)/2;
			int partitiony=(x.length+y.length+1)/2-partitionx;
			
			int maxleftx=(partitionx==0)?Integer.MIN_VALUE:x[partitionx-1];
			int minrightx=(partitionx==x.length)?Integer.MAX_VALUE:x[partitionx];
			
			int maxlefty=(partitiony==0)?Integer.MIN_VALUE:y[partitiony-1];
			int minrighty=(partitiony==y.length)?Integer.MAX_VALUE:y[partitiony-1];
			
			if(maxleftx<=minrighty && minrightx>=maxleftx) {
				if((x.length+y.length)%2==0) {
					return ((double)Math.max(maxleftx,maxlefty)+Math.min(minrightx, minrighty))/2;
				}
				else {
					return (double)Math.max(maxleftx, maxlefty);
				}
			}
			else if(maxleftx>minrighty) {
				end=partitionx-1;
			}
			else
				start=partitionx+1;
		}
		throw new IllegalArgumentException();  // if arrays are not sorted
	}

}
