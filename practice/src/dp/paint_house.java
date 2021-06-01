package dp;

public class paint_house {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int cost(int[][] costs) {
		if(costs==null || costs.length==0) {
			return 0;
		}
		int[][] matrix=new int[3][costs.length];
		for(int j=0;j<costs.length;j++) {
			if(j==0) {
				matrix[0][j]=costs[j][0];
				matrix[1][j]=costs[j][1];
				matrix[2][j]=costs[j][2];
				
			}
			else {
				matrix[0][j]=Math.min(matrix[1][j-1], matrix[2][j-1]);
				matrix[1][j]=Math.min(matrix[0][j-1], matrix[2][j-1]);
				matrix[2][j]=Math.min(matrix[0][j-1], matrix[1][j-1]);
			}
		}
		int result=Math.min(matrix[0][costs.length-1], matrix[1][costs.length-1]);
		result=Math.min(result, matrix[2][costs.length-1]);
		
		return result;
	}

}
