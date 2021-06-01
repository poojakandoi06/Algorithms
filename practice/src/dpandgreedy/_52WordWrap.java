package dpandgreedy;

import java.util.*;

public class _52WordWrap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int x = 1;
		while (t-- > 0) {
			String str = s.next();
			int bigo = 0;
			int so = 0;
			int count = 0;
			for (int i = str.length() - 1; i >= 0; i--) {
				char c = str.charAt(i);

				if (c == 'O')
					bigo++;
				else if (c == 'o')
					so++;
				else if (c == 'i') {
					if (so > 0) {
						so--;
					} else {
						bigo--;
					}
				} else {
					if (bigo > 0) {
						count++;
						bigo--;
					} else {
						so--;
					}
				}
			}

			System.out.println("Case #" + x + ": " + count);
			x++;
		}
	}
}