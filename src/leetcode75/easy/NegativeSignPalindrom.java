package leetcode75.easy;

public class NegativeSignPalindrom {
	
	public static void negativePlaindrom(int num) {
		int sign=0;
		int palinNum = 0;
		int reverseNum=0;
		
		if (num < 0) {
			sign = -1;
			palinNum = Math.abs(num);
		}
		while (palinNum>0) {
			reverseNum = reverseNum*10+palinNum%10;
			palinNum = palinNum/10;
		}
		if (reverseNum==Math.abs(num)) {
			if (sign == -1) {
				reverseNum = reverseNum*sign;
			}
			System.out.print("Palindrom  "+reverseNum);
		}else {
			System.out.print("Not Palindrom " +num);
		}
		
		
	}
	
	public static void main(String[] args) {
		negativePlaindrom(-1221);
		
	}

}
