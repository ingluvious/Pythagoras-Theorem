import java.util.*;
import java.lang.*;
import java.io.*;
import java.lang.Math.*;

public class ThreesX{
	
	public static void main(String args[]){
		ThreesX sortNow = new ThreesX();//Enables the use of lists for sorting
		sortNow.increasingX();
	}
	
	private static long gcd(long a, long b, long c){
		long limit = Math.min(a, b);
		limit = Math.min(limit, c);
		for(long n = limit; n >= 2; n--){
			if ( (a % n == 0) && (b % n == 0) && (c % n == 0) ) {
				return n;
			}
		}
		return 1;
	}
	
	private static void increasingX(){
		System.out.println("============ First 350 Sets in increasing order of X followed by Y ============");
		int count = 0;
		
		long y;
		long x = 5;
		List<Long> yvals = new ArrayList<Long>();
		List<Long> zvals = new ArrayList<Long>();
  
		while(count<350){
			for(long z = 1; z<x; z++) {
				y = (int) Math.sqrt(x*x - z*z);
				if((y*y + z*z) == x*x && z<y && gcd(x,y,z)==1) {
					yvals.add(y);
					zvals.add(z);
					count++;
				}
			}
			while(yvals.size() > 0){
				int index = yvals.indexOf(Collections.min(yvals));
				System.out.println(x + " " + yvals.get(index) + " " + zvals.get(index));
	   yvals.remove(index);
			}
			yvals.clear();
			zvals.clear();
			x+=5;
		}
	}
}