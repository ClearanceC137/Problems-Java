import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	/* -- given an unlimited supply of coins given denominations, find
	   the total  number of distinct ways to get desired change --  */  
	 public static int CoinChange(int [] array , int value) {
		 // recursively reduce the problem by calling value - x
		 // x is a possible coin which will be included to giving the change
		int count = 0;
		if( value == 0 ) {
			return 1;
		}
		
		if ( value < 0) {
			return 0;
		}
		for( int i : array) {	
			count += CoinChange(array , value - i);
		}
		return count;
	}
	
	 
	/* -- given a string return its reversed counterpart -- */ 
	public static String Reverse(String str){
		// base case because an empty string is reversed
		if ( str.equals("")) {
			return "";
		}
		// recursive definition taken from a case when the string has two characters
		// which would imply the reverse is str[0] + str[1]
		return Reverse(str.substring(1))+str.charAt(0);
	}
	
	/* -- check if a given string is a palindrome  -- */
	public static boolean Palindrome(String str){
		// base case is when we have a single character
		// which is the character separating two parts of a palindrome
		if( str.length() == 1) {
			System.out.println("size 1");
			return true;
		}
		if( str.charAt(0) == str.charAt(str.length()-1) ) {
			// reduces the problem by comparing the start and end part
			// then excluding them on the next function call
			return Palindrome(str.substring(1, str.length()-1));
		}
		
		return false;
	}
	/* -- an iterator find what number it is on a queue -- */
	public static int Count(Iterator<Integer> it) {
		//base case is when we reached front of the queue
		if(!it.hasNext()) {
			return 0;
		}
		it.next();
		// the current node's number is 1 + number of the next node
		return 1+Count(it);
	}
	
	/* -- convert a decimal number to a binary string -- */
	public static String Conversion(int value , String result) {
		// divide till value is 0 which is used as stopping criteria
		if( value == 0) {
			return result;
		}
		//reminder is the part of the binary digit
		result = value%2 + result;
		// divide while collecting reminder
		return Conversion(value/2 , result);
	}
	
	/* get sum of all natural number that comes before the value */
	public static int SumOfNaturalNumber(int value) {
		// base case is that sum of 1 is 1
		if( value == 1) {
			return 1;
		}
		// use definition of solution i.e if value = 10 sum =10+9+8...
		return value+SumOfNaturalNumber(value-1);
	}
	
	/* -- Implementation of a binary search algorithm -- */
	public static boolean BinarySearch(int[] array ,int value, int left , int right) {
		if( left > right) {
			return false;
		}
		int mid = (left+right)/2;
		if( array[mid] == value) {
			return true;
		}
		if( value < array[mid]) {
			return BinarySearch(array ,value,left , mid-1);
		}else {
			return BinarySearch(array ,value,mid+1 , right);
		}
	}
	
	/* -- fibonacci with memoization -- */
	public static int Fibonacci(int n , int[] memo) {
		if ( n==0 ) {
			return 0;
		}
		if( n==1) {
			return 1;
		}
		
		if( memo[n] == 0) {
			memo[n] = Fibonacci(n-1 , memo)+Fibonacci(n-2,memo);
			return memo[n];
		}else {
			return memo[n];
		}
		
	}
}