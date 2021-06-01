package Lunchtime_Aug;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RRGAME {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int t = s.nextInt();
			while (t-- > 0) {
				int n = s.nextInt();
				int[] arr = new int[n];
				for (int i = 0; i < n; i++)
					arr[i] = s.nextInt();
				ArrayList<Integer> list = new ArrayList<>();
				int count = 0;
				for (int i = 0; i < n; i++) {
					if (arr[i] == 0)
						count++;
					else {
						if (count > 0)
							list.add(count);
						count = 0;
					}
				}
				Collections.sort(list, Collections.reverseOrder());
				int res = 0;
				if (list.size() == 0)
					res = 1;
				else if (list.get(0) % 2 == 0)
					res = 1;
				else {
					if (list.size() > 1 && list.get(1) >= (list.get(0)+1)/2) {
						res = 1;
					} else {
						res = 0;
					}
				}

				if (res == 1)
					System.out.println("No");
				else
					System.out.println("Yes");
			}
		} catch (Exception e) {
			System.out.println(e);
			return;
		}

	}

}
