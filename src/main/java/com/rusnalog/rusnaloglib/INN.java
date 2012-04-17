package com.rusnalog.rusnaloglib;

import java.util.Random;

public class INN {
	
	public INN( String code ) {
		this.code = code;
	}
	
	public String getStr() {
		return code;
	}
	
	private String code = null;
	
	public static boolean checkValid( INN inn ) {
		return isValidInnStr( inn.getStr() );
	}
	
	public static boolean isValidInnStr( String inn ) {		
		
		return innNumberValid( inn ) & innControlDigitsValid( inn );
	}
	
	public static boolean innNumberValid( String inn ) {
		// TODO:
		return true;
	}
	
	public static boolean innControlDigitsValid( String inn ) {
		if( inn.length() == 10 ) {
			char digit10 = Integer.toString( compute10Digit(inn) ).charAt( 0 );
			
			if( inn.charAt(9) != digit10 )
				return false;
			
			return true;
		}
		else if( inn.length() == 12 ) {
			char digit11 = Integer.toString( compute11Digit(inn) ).charAt( 0 );
			
			if( inn.charAt(10) != digit11 )
				return false;
			
			char digit12 = Integer.toString( compute12Digit(inn) ).charAt( 0 );
			
			if( inn.charAt(11) != digit12 )
				return false;
			
			return true;
		}
		return false;
	}
	
	public static String generateFis( String region_id, String inspec_id ) {
		String ret = new String();
		
		ret += region_id;
		ret += inspec_id;
		
		int num = Utils.generateRandomDigits(6);
		
		ret += Integer.toString(num);
		
		int digit11 = compute11Digit(ret);
		
		ret += digit11;
		
		int digit12 = compute12Digit(ret);
		
		ret += digit12;
		
		return ret;
	}
	
	public static String generateUrid( String region_id, String inspec_id ) {
		String ret = new String();
		
		ret += region_id;
		ret += inspec_id;
		
		int num = Utils.generateRandomDigits(5);
		
		ret += Integer.toString(num);
		
		int digit10 = compute10Digit(ret);
		
		ret += digit10;
		
		return ret;
	}
	
	public static int compute10Digit( String inn ) {
		int n1 = Character.digit( inn.charAt(0), 10 );
		int n2 = Character.digit( inn.charAt(1), 10 );
		int n3 = Character.digit( inn.charAt(2), 10 );
		int n4 = Character.digit( inn.charAt(3), 10 );
		int n5 = Character.digit( inn.charAt(4), 10 );
		int n6 = Character.digit( inn.charAt(5), 10 );
		int n7 = Character.digit( inn.charAt(6), 10 );
		int n8 = Character.digit( inn.charAt(7), 10 );
		int n9 = Character.digit( inn.charAt(8), 10 );
		
		int res = 2*n1 + 4*n2 + 10*n3 + 3*n4 + 5*n5 + 9*n6 + 4*n7 + 6*n8 + 8*n9;
		res = res % 11;
		res = res % 10;
		
		return res;
	}

	public static int compute11Digit( String inn ) {
		int n1 = Character.digit( inn.charAt(0), 10 );
		int n2 = Character.digit( inn.charAt(1), 10 );
		int n3 = Character.digit( inn.charAt(2), 10 );
		int n4 = Character.digit( inn.charAt(3), 10 );
		int n5 = Character.digit( inn.charAt(4), 10 );
		int n6 = Character.digit( inn.charAt(5), 10 );
		int n7 = Character.digit( inn.charAt(6), 10 );
		int n8 = Character.digit( inn.charAt(7), 10 );
		int n9 = Character.digit( inn.charAt(8), 10 );
		int n10 = Character.digit( inn.charAt(9), 10 );
		
		int res = 7*n1 + 2*n2 + 4*n3 + 10*n4 + 3*n5 + 5*n6 + 9*n7 + 4*n8 + 6*n9 + 8*n10;
		res = res % 11;
		res = res % 10;
		
		return res;
	}
	
	public static int compute12Digit( String inn ) {
		int n1 = Character.digit( inn.charAt(0), 10 );
		int n2 = Character.digit( inn.charAt(1), 10 );
		int n3 = Character.digit( inn.charAt(2), 10 );
		int n4 = Character.digit( inn.charAt(3), 10 );
		int n5 = Character.digit( inn.charAt(4), 10 );
		int n6 = Character.digit( inn.charAt(5), 10 );
		int n7 = Character.digit( inn.charAt(6), 10 );
		int n8 = Character.digit( inn.charAt(7), 10 );
		int n9 = Character.digit( inn.charAt(8), 10 );
		int n10 = Character.digit( inn.charAt(9), 10 );
		int n11 = Character.digit( inn.charAt(10), 10 );
		
		int res = 3*n1 + 7*n2 + 2*n3 + 4*n4 + 10*n5 + 3*n6 + 5*n7 + 9*n8 + 4*n9 + 6*n10 + 8*n11;
		res = res % 11;
		res = res % 10;
		
		return res;
	}
}
