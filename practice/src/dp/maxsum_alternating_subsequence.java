package dp;

public class maxsum_alternating_subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int msas(int[] arr) {
		int n=arr.length;
		if(n==1)
			return arr[0];
		
		int[] dec=new int[n];
        int[] inc=new int[n];
        
        dec[0]=inc[0]=arr[0];
        int flag=0;
        for(int i=0;i<n;i++) {
        	for(int j=0;j<i;j++) {
        		if(arr[j]>arr[i]) {
        			dec[i]=Math.max(dec[i],inc[j]+arr[i]);
        			flag=1;
        		}
        		else if(arr[j]<arr[i] && flag==1){
        			inc[i]=Math.max(inc[i],dec[j]+arr[i]);
        		}
        	}
        }
        int result=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
        	result=Math.max(result,Math.max(inc[i], dec[i]));
        }
		return result;
		
	}

}
