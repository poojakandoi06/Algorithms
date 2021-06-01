package dp;

public class burst_ballons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= {3,1,5,7};
		System.out.println(maxcostdp(arr));

	}
	public static int maxcostrec(int[] nums) {
		int[] nums1=new int[nums.length+2];
		nums1[0]=1;
		nums1[nums1.length-1]=1;
		for(int i=0;i<nums.length;i++) {
			nums1[i+1]=nums[i];
		}
		if(nums1.length==2) {
			return 0;
		}
		int max=0;
		for(int i=1;i<nums1.length-1;i++) {
			int val=nums1[i-1]*nums1[i]*nums1[i+1]+maxcostrec(formnewaarray(nums1,i));
			if(val>max)
				max=val;
			
		}
		return max;
		
	}
	public static int maxcostdp(int[] nums) {
		int[][] dp=new int[nums.length][nums.length];
		for(int len=1;len<=nums.length;len++) {
			for(int i=0;i<=nums.length-len;i++) {
				int j=i+len-1;
				for(int k=i;k<=j;k++) {
					int leftvalue=1;
					int rightvalue=1;
					if(i!=0) {
						leftvalue=nums[i-1];
					}
					if(j!=nums.length-1) {
						rightvalue=nums[j+1];
					}
					int before=0;
					int after=0;
					if(i!=k)
						before=dp[i][k-1];
					if(j!=k)
						after=dp[k+1][j];
					dp[i][j]=Math.max(leftvalue*nums[k]*rightvalue+before+after,dp[i][j]);
				}
				
				
			}
		}
		return dp[0][nums.length-1];
	}
		private static int[] formnewaarray(int[] nums1, int idx) {
			int[] newarray=new int[nums1.length-1];
			int index=0;
			for(int i=0;i<nums1.length;i++) {
				if(i==idx) {
					continue;
				}
				newarray[index++]=nums1[i];
			}
			return newarray;
		}

}
