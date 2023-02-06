import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	/* -- function to sum the numbers without using any arithmetic operators --*/
	public static int Sum(int value1 , int value2) {
		// add +1 to either of the variable while using the other one as the loop range
		for(int i = 0 ; i < value1 ; i++) {
			value2++;
		}
		return value2;
	}
	
	/* -- Given a stack, sort the elements in the stack using one additional -- */
	public static Stack<Integer> SortStack(Stack<Integer>sq1){
		Stack<Integer> sq2 = new Stack<>();
		int sorted = 0;
		int size = sq1.size();
		while(true) {
			// locate minimum value in the stack while using the other stack to access
			// all elements
			Integer min = sq1.peek();
			for( int  j = sorted ; j < size ; j++) {
				if(sq1.peek() < min ) {
					min = sq1.peek();
				}
				sq2.push(sq1.peek());
				sq1.pop();
			}
			// push minumum value inside the empty stack and increment number
			// of sorted elements i.e sorted++
			sq1.push(min);
			while( !sq2.empty()) {
				// delete the minimum value from the second stack
				// this way we ensure number of iteration is reduced
				// each time we find minimum value
				if( sq2.peek().equals(min)) {
					sq2.pop();
				}
				sq1.push(sq2.peek());
				sq2.pop();
			}
			sorted++;
			if ( sorted == sq1.size() -1) {
				// the algorithm finished sorted as all the element
				// are in the correct position
				break;
			}
		}
		
		return sq1;
		
	}
	/* -- Given an array containing all the numbers from 1 to n 
	          except two,find the two missing numbers       -- */

	public static void Missing(int array[] , int n) {
		boolean[] track = new boolean[n];
		// since the elements are from 1 to n declare a boolean array
		// to track which  numbers are missing
		for(int i = 0 ; i < array.length ; i++) {
			// if number is present set its value to true
			// inside the bool array
			track[array[i]-1] = true;
		}
		// locate position/index with boolean value of false
		// that is the missing value
		for(int i = 0 ; i < n ; i++) {
			if(!track[i]) {
				System.out.println(i+1);
			}
		}
	}
	/* -- Given two integers, write a function to determine whether
	    or not their binary representations differ by a single bit. -- */
	
	public static boolean differBySingleBit(int a , int b) {
		/*  use the XOR logic operation
		 * if the digit differ by a single digit 
		 * the string arquired from aXORb should only contain 
		 * a single 1 binary value  */
		String str = Integer.toBinaryString(a^b);
		int count = 0 ;
		for( int i = 0 ; i < str.length() ; i++) {
			// count the number of 1's from aXORb string
			if('1' == str.charAt(i)) {
				count++;
			}
		}
		if( count == 1) {
			return true;
		}
		return false;
	}
	
	/* -- determine whether a graph contains a cycle  -- */
	public static boolean Cycle() {
		HashMap<Integer,Integer> map = new HashMap<>(); // (node1, node2) form an edge
		map.put(1, 2);
		map.put(2, 3);
		map.put(3, 4);
		map.put(4, 2);
		HashSet<Integer> sets = new HashSet<>();
		int curr = 1;
		while(true) {
			// keep track of visited nodes
			if(sets.contains(curr)) {
				// if node is seen but visited again 
				//the graph has cycles
				return true;
			}
			sets.add(curr);
			if( map.get(curr) == null) {
				return false;
			}
			curr = map.get(curr);
		}
		
	}
	/* -- Given a list of integers, write a function that returns all sets of 3
            numbers in the list, a, b, and c, so that a + b + c == 0      -- */
	public static ArrayList<Integer> ThreeSum(int[] array){
		ArrayList<Integer> list = new ArrayList<>();
		// Form all three different combination from all the elements inside an array
		for(int i = 0 ; i < array.length ; i++ ) {
			for(int j = i+1 ; j < array.length ; j++ ) {
				for(int k = j+1 ; k < array.length ; k++ ) {
					if(array[i] + array[j] + array[k] == 0) {
						list.add(array[i]);
						list.add(array[j]);
						list.add(array[k]);	
						return list;
					}
				}				
			}			
		}
		
		return list;
	}
	/* -- Write an auto complete class that returns
	       all dictionary words with a    -- */               
	public static void AutoComplete(String[] dict , String prefix) {
		// check if dict[i] cointains the prefix
		for(int i = 0 ; i < dict.length ; i++) {
			if( dict[i].toLowerCase().startsWith(prefix.toLowerCase())) {
				System.out.println(dict[i]);
			}
		}
	}
	/* --- Given two strings, write a function that 
	       returns the longest common substring.    ---  */
	public static String LongestSubString(String str1,String str2) {
		String SubStr ="";
		//use 1 string to find all possible prefix
		// then check if the second string contains the prefix
		for(int i = 0 ; i < str1.length() ; i++) {
			String str = str1.substring(i);
			if( str2.contains(str)) {
				if(SubStr.length() < str.length()) {
					// update only if substring length is less than the new substring 
					SubStr = str;
				}
			}
		}
		return SubStr;
	}
	/* -- Given an integer n, write a function to compute the nth Fibonacci -- **/
	public static int Fibonacci(int n) {
		// use recursion and definition of Fibanacci series
		if( n == 0) {
			return 0;
		}
		else if(n ==1) {
			return 1;
		}
		else {
			return Fibonacci(n-1)+Fibonacci(n-2);
		}
	}
/* -- Given a string, write a function to compress it by shortening every sequence
    of the same character to that character followed by the number of repetitions  -- */	
	public static String Compress(String str) {
		// use hash map to store key as a character and number of occurrences as value
		HashMap<String,Integer> map = new HashMap<>();
		for(int  i = 0 ; i < str.length() ; i++) {
			// loop through the strings whilst updating the hash map
			if(map.containsKey(Character.toString(str.charAt(i)))) {
				int value = map.get(Character.toString(str.charAt(i)));
				map.put(Character.toString(str.charAt(i)), ++value);
			}else {
				map.put(Character.toString(str.charAt(i)), 1);
			}
		}
		// loop through the hash map to created the final compressed string
		String compressed ="";
		for(Map.Entry<String, Integer> set : map.entrySet()) {
			compressed+=set.getKey()+""+set.getValue();
		}
		// compression did not reduce size of string so return original
		if(compressed.length() > str.length()){
			return str;
		}
		
		return compressed;
	}
	/* --  Given a list of strings, write a function to get the kth most frequently
                              occurring string.                                    -- */
	public static String kthMostFrequent(String [] array , int k) {
		// use a hash map to store key as character and value as number of occurrences
		HashMap<String,Integer> map = new HashMap<>();
		for(int  i = 0 ; i < array.length ; i++) {
			if(map.containsKey(array[i])) {
				int value = map.get(array[i]);
				map.put(array[i], ++value);
			}else {
				map.put(array[i], 1);
			}
		}
		String maxKey = "";
		for(int i = 0 ; i < k+1 ; i++) {
			// search for the character with max number of occurrences
			// since are searching for the kth most frequently 
			// eliminate k+1 most frquently 
			int max = 0;
			for(Map.Entry<String, Integer> set : map.entrySet()) {				
				if ( set.getValue() > max) {
					max = set.getValue();
					maxKey = set.getKey();
				}
			}
			max = 0;
			map.remove(maxKey);
			if(map.isEmpty()) {
				// k is greater than number of unique characters
				return null;
			}
		}
		
		return maxKey;
	}
	/* -- Write a function that returns all permutations of a given string.  -- */
	public static ArrayList<String>  Permutation(String str) {
		String copy = str;
		ArrayList<String> list = new ArrayList<>();
		// idea is to swap two character which gives a unique string
		while(true) {
			for(int  i = 0 ; i < str.length()-1 ; i++) {
				str = Swap(str,i);
				list.add(str);
				if( str.equals(copy)) {
					// all possible permutation have been made
					return list;
				}
			}
			
		}
	}
	/* -- a helper function to swap two characters in a given string -- */
	public static String Swap(String str , int index) {
		return str.substring(0, index)+str.charAt(index+1)+str.charAt(index)+str.substring(index+2, str.length());
	}
	

	public static int factorial(int value) {
		if(value == 1 || value == 0) {
			return 1;
		}
		return value*factorial(value-1);
	}
	/* -- Given an unsorted integer array , find a pair with a given sum -- */	
	public static ArrayList<ArrayList<Integer>> SumPair(int []array , int sum){
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		// find the sum of a single value at index i with i+1 other elements whilst check if the sum 
		// is equal to the variable passed
		for(int i = 0 ; i < array.length ; i++) {
			for( int j = i+1 ; j <array.length ; j++) {
				if(array[i]+array[j] == sum) {
					list.add(new ArrayList<Integer>(Arrays.asList(array[i],array[j])));
				}
			}
		}
		return list;
	}
	/* -- Given an integer array, find a contiguous
	      sub array within it that has the largest sum -- */
	public static int[] MaxSubArray(int [] array) {
		int [] arr = new int[2];
		int sum = 0;
		// from index i continuously check if the sum is largest whilst 
		// increasing the size of sub array
		for(int i = 0 ; i < array.length ; i++) {
			for( int j = i+1 ; j < array.length-1 ; j++) {
				int currentsum = Sum(array , i , j);
				if ( sum < currentsum) {
					arr[0] = i;
					arr[1] = j;
					sum = currentsum;
				}
			}
		}
		return arr;
	}
	/* --  helper function which returns the sum of the array -- */
	public static int Sum(int [] array , int lower , int upper) {
		int sum = 0;
		for(int i = lower ; i<= upper ; i++) {
			sum+=array[i];
		}
		return sum ;
	}

}
