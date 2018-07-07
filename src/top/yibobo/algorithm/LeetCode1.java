package top.yibobo.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LeetCode1 {

	public static void main(String[] args) {
		
		LeetCode1 lc = new LeetCode1();
		
		/*int[] arr = {0,1,3,4,8};
		System.out.println(Arrays.toString(lc.twoSum2(arr, 9)));*/
		
		Map<String,Integer> map = new HashMap<>();
        map.put("I",0);
        map.put("V",1);
        map.put("X",2);
        map.put("L",3);
        map.put("C",4);
        map.put("D",5);
        map.put("M",6);
        
        
        
	}
	
	//两数之和1
	public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i <= nums.length-2 ; i++){
            for(int j = i+1 ; j<=nums.length-1 ; j++){
                if(nums[i]+nums[j]==target){
                    int[] arr = {i,j};
                    return arr;
                }
            }
        }
        return null;
    }
	//两数之和2
	public int[] twoSum2(int[] nums, int target) {
		
		Map<Integer,Integer> map = new HashMap<>();//哈希表用来存储每次遍历出的数据，key为数组中的值，value为此值对应的索引
		for(int i = 0;i<nums.length;i++) {
			
			int temp = target - nums[i];//target减去遍历出来的数字（即nums[i]）,如果在哈希表中存在，则找到正确答案
			
			if(map.containsKey(temp)) {
				return new int[] {map.get(temp),i};
			}
			
			map.put(nums[i], i);//否则将遍历出来的值作为键、索引作为值存入哈希map
		}
		
		return null;
	}
	
	//反转整数
	public int reverse(int x) {
		String str = x+"";
        char[] chars = str.toCharArray();
        char c = '+';
        if(chars[0]=='-'){
           c = '-'; 
        }
        
        StringBuffer sb = new StringBuffer(c+"");
        for(int i = chars.length-1 ; i >= 0 ; i--){
            if(i==0 && c=='-'){
                break;
            }
            sb.append(chars[i]);
        }
        
        int y = 0;
        try{
            y = Integer.parseInt(sb.toString());
        }catch(Exception e){}
        
        return y;
        
    }

	//回文数：判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
	public boolean isPalindrome(int x) {
        
        
        if(x<0) return false;
        
        int y = x;
        
        long rev = 0;
        while(x != 0){
            rev = rev*10+x%10;
            x /= 10;
        }
        
        return rev == y;
        
    }
	
	
	//13.罗马数字转整数
	public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        char[] chars = s.toCharArray();
        int num = 0;
        for(int i = 0 ; i < chars.length ; i++){
            if(i+1 != chars.length && map.get(chars[i]) < map.get(chars[i+1])){
                num = num+(map.get(chars[i+1]) - map.get(chars[i]));
                i++;
            }else{
                num+=map.get(chars[i]);
            }
            
        }
        
        return num;
    }
	
}
