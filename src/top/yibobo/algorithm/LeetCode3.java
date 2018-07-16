package top.yibobo.algorithm;

public class LeetCode3 {

	public static void main(String[] args) {
		
	}
	
	//26. 删除排序数组中的重复项
	public int removeDuplicates(int[] nums) {
        int i = 0 ; 
        
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        
        return i+1;
    }
	
	
	//27. 移除元素
	public int removeElement(int[] nums, int val) {
        int i = nums.length - 1;
        
        for(int j = nums.length-1 ; j >= 0 ; j--){
            if(nums[j]==val){
                nums[j] = nums[i];
                i--;
            }
        }
        
        return ++i;
    }
	
	
	
	//28. 实现strStr(),就是java里的indexOf()
	public int strStr(String haystack, String needle) {
        
        if(needle.equals("") || haystack.equals(needle))return 0;
        
        
        char[] arr = haystack.toCharArray();
        char[] arr2 = needle.toCharArray();
        
        for(int i = 0 ; i <= arr.length-arr2.length ; i++){
            if(arr[i]==arr2[0]){
                boolean flag = true;
                for(int j = 1 ; j < arr2.length ; j ++){
                    
                    if(arr[i+j] != arr2[j]){
                        flag = false;
                        break;
                    } 
                }
                
                if(flag)return i;
            }
            
        }
        
        
        
        return -1;
    }
	

}
