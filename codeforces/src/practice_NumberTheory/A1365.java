package practice_NumberTheory;

import java.util.PriorityQueue;
import java.util.Scanner;

public class A1365 {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int t = s.nextInt();
			while (t-- > 0) {
				int n = s.nextInt();
				int m = s.nextInt();
				int[] row = new int[n];
				int[] col = new int[m];
				int[][] arr = new int[n][m];
				int[] ur=new int[n];
				int[] uc=new int[m];
				PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
						(a, b) -> ((row[b[0]] + col[b[1]] - 1) - (row[a[0]] + col[a[1]] - 1)));
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						arr[i][j] = s.nextInt();
						if (arr[i][j] == 0) {
							row[i]++;
							col[j]++;
						}
						else {
							ur[i]++;
							uc[j]++;
						}
					}
				}
				for(int i=0;i<n;i++) {
					for(int j=0;j<m;j++) {
						if(arr[i][j]==0 && ur[i]==0 && uc[j]==0)
							pq.add(new int[] {i,j});
					}
				}
				boolean Aturn = true;
				while (pq.size() > 0) {
					int[] poll = pq.poll();
					int i = poll[0];
					int j = poll[1];
					
					if (row[i] > 0 && col[j] > 0) {
						row[i] = 0;
						col[j] = 0;
						Aturn= !Aturn;
					} 
				}
				if(Aturn==true) {
					System.out.println("Vivek");
				}
				else {
					System.out.println("Ashish");
				}

			}

		} catch (Exception e) {
			System.out.println(e);
			return;
		}

	}

}
