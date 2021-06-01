package trees;

public class pre_to_post {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pre= {40,30,35,80,100};
		pretoPost(pre);

	}
	static int preindex=0;
	public static void pretoPost(int[] pre) {
		findpost(pre,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	private static void findpost(int[] pre,int minValue, int maxValue) {
		if(preindex>=pre.length || pre[preindex]>maxValue || pre[preindex]<minValue)
			return;
		int val=pre[preindex];
		preindex++;
		findpost(pre, minValue,val);
		findpost(pre, val, maxValue);
		System.out.print(val+" ");
		
	}

}
