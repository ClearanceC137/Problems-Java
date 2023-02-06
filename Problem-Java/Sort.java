import java.util.ArrayList;
import java.util.LinkedList;

public class Sort {
	
	public static void main(String [] args) {
		int array[] = {12,11,13,5,6,7};
		MergeSort(array,0,array.length-1);
		for(int i = 0 ; i < array.length ; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void MergeSort( int array[] ,int left , int right){
		if (left < right) {
			int middle = (right+left)/2;
			MergeSort(array , left , middle);
			MergeSort(array , middle+1,right);
			Merge(array,left,middle,right);
		}
		
	}
	
	public static void Merge(int array[] , int left , int middle, int right){
		int size1 = middle-left+1;
		int size2 = right - middle;
		int arr1[] = new int[size1];
		int arr2[] = new int[size2];
		
		for( int i = 0 ; i < size1 ; i++) {
			arr1[i] = array[left+i];
		}
		for(int  i = 0 ; i < size2 ; i++ ) {
			arr2[i] = array[middle+1+i];
		}
		int i = 0 , j = 0;
		int k = left;
		while( i < size1 && j < size2) {
			if( arr1[i] <= arr2[j] ) {
				array[k] = arr1[i];
				i++;
			}else {
				array[k] = arr2[j];
				j++;
			}
			k++;
		}
		
		while ( i < size1) {
			array[k] = arr1[i];
			k++;
			i++;
		}
		while ( j < size2) {
			array[k] = arr2[j];
			k++;
			j++;
		}
	}

}
