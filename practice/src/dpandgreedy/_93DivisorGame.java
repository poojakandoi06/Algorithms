package dpandgreedy;

public class _93DivisorGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean divisorGame(int N) {
	    return N%2==0;
	}
	/*Explanation: if you carefully obeserve you lose when N=1 and win when N=2;
	so from N=3 just apply induction whenevever you have odd value it can only have odd divisors
	 so when you subtract odd divisor from N then N will become even for your opponent so he wins and
	  when N is even you are always able to create a situation of N is odd for your opponent by just subtracting 1 as
	   1 ia a divisor of all postive numbers.
	    So the bottom line is when N is odd you will lose and when n is even you make N odd by subtracting 1 leaving your opponent with odd value of N */


}
