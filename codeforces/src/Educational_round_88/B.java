package Educational_round_88;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			int m = s.nextInt();
			int x = s.nextInt();
			int y = s.nextInt();
			char[][] arr = new char[n][m];
			int res = 0;
			for (int i = 0; i < n; i++) {
				String str = s.next();
				int curr=0;
				for (int j = 0; j < m; j++) {
					arr[i][j] = str.charAt(j);
					if(arr[i][j]=='.')
					{
						curr++;
					}
					else {
						res=res+Math.min((curr/2)*y+(curr%2)*x,curr*x);
						curr=0;
					}
				}
				res=res+Math.min((curr/2)*y+(curr%2)*x,curr*x);

			}
			System.out.println(res);

		}

	}

}
