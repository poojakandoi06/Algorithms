package dp;

public class paint_house_v2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int min_cost(int[][] costs) {
		if(costs.length==0 || costs==null)
			return 0;
		int pre_min=0;
		int pre_second=0;
		int pre_index=-1;
		for(int i=0;i<costs.length;i++) {
			int curr_min=Integer.MAX_VALUE;
			int curr_Second=Integer.MAX_VALUE;
			int curr_index=0;
			for(int j=0;j<costs[0].length;j++) {
				if(pre_index==j) {
					costs[i][j]+=pre_second;
				}
				else {
					costs[i][j]+=pre_min;
				}
				
				if(curr_min>costs[i][j]) {
					curr_Second=curr_min;
					curr_min=costs[i][j];
					curr_index=j;
				}
				else if(curr_Second>costs[i][j]) {
					curr_Second=costs[i][j];
				}
			}
			pre_min=curr_min;
			pre_second=curr_Second;
			pre_index=curr_index;
		}
		int res=Integer.MAX_VALUE;
		for(int j=0;j<costs[0].length;j++) {
			res=Math.min(res, costs[costs.length][j]);
		}
		return res;
	}

}
