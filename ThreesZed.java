import java.util.*;
import java.lang.*;
import java.io.*;
import java.lang.Math.*;

public class ThreesZed{
	public static void main(String args[]) {
		increasingZed();
	}
	
	private static long gcd(long a, long b, long c)
	{
		long limit = Math.min(a, b);
		limit = Math.min(limit, c);
		for(long n = limit; n >= 2; n--)
		{
			if ( (a % n == 0) && (b % n == 0) && (c % n == 0) ) {
				return n;
			}
		}
		
		return 1;
	}
	
	private static void increasingZed() {
		System.out.println("============ First 350 Sets in order of Increasing Z =============");
		
		int count = 0;
		long z = 1;
		
		while(count<350){
			for(long y = 2; y<500000; y++) {
				long x = (int)Math.sqrt(z*z + y*y);
				if(z*z == x*x - y*y && y>z && x%5 == 0 && gcd(x,y,z)==1) {
					System.out.println(x + " " + y + " " + z);
					count++;
				}
			}
			z++;
		}
	}
}