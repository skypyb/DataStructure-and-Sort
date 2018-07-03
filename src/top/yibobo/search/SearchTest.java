package top.yibobo.search;

public class SearchTest {
	public static void main(String[] args) {
		
		int array[] = {0,1,2,3,5,7,9,14,57,67,178,322,478,1450};
		
		int mid = Search.BinarySearch(array, 322);
		System.out.println(mid);
		mid = Search.BinarySearch(array, 322, 0, array.length-1);
		System.out.println(mid);
	}
}
