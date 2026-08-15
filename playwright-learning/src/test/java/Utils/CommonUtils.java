package Utils;

import java.util.Random;

public class CommonUtils {
	
	public static int randomDigitGenerator(int n) {
		Random random = new Random();
		int min=(int) Math.pow(10, n-1);
		int max=(int) Math.pow(n, n+1);
		int k=random.nextInt(max-min+1);
		return k;
	}
	
	public static String randomStringGenerator(int n) {
	    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    Random random = new Random();
	    StringBuilder sb = new StringBuilder();

	    for (int i = 0; i < n; i++) {
	        sb.append(chars.charAt(random.nextInt(chars.length())));
	    }

	    return sb.toString();
	}
}
