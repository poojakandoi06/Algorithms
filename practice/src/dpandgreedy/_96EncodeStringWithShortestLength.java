package dpandgreedy;

public class _96EncodeStringWithShortestLength {

	public static void main(String[] args) {
		String str = "ppqrppqrst";
		solution(str);

	}
	
	public static void solution(String str) {
		int len = 1;
		StringBuilder ans = new StringBuilder();
		for(int i = 0, j = 1 ; j < str.length(); i++, j++) {
			if(str.charAt(i) == str.charAt(j)) {
				len++;
			}else {
				if(len > 4) {
					ans.append(len + "[" + str.charAt(i) + "]");
				}else {
					for(int count = 0 ; count < len; count++) {
						ans.append(str.charAt(i));
					}
				}
				len = 1;
			}
		}
		if(len > 4) {
			ans.append(len + "[" + str.charAt(str.length() - 1) + "]");
		}else {
			for(int count = 0 ; count < len; count++) {
				ans.append(str.charAt(str.length() - 1));
			}
		}
		System.out.println(ans.toString());
	}

}
