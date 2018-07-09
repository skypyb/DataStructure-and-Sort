package top.yibobo.algorithm;

import java.util.Stack;

public class LeetCode2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Character> st;
		String str;
		
		
	}
	
	//14.最长公共前缀
	public String longestCommonPrefix(String[] strs) {
        String str = "";
        //str += strs[0].charAt(0);
        
        if(strs.length==0 || strs == null)return str;
        
        
        for(int i = 0 ; i <strs[0].length() ; i ++){
            
            
            for(int j = 0  ; j < strs.length-1 ; j++ ){
                
                try{
                    if(strs[j].charAt(i) != strs[j+1].charAt(i))return str;
                }catch(Exception e){
                    return str;
                }
            }
            str += strs[0].charAt(i);
            
        }
        
        return str;
    }
	
	//20. 有效的括号
	public boolean isValid(String s) {
        if(s == null || s.length()==1) return false;
        //if(s.equals(""))return true;
        
        Stack<Integer> st = new Stack<>();
        
        for(int c:s.toCharArray()){
            
            if(c == '{' || c=='(' || c=='['){
               st.push(c); 
            }else{
                if(st.empty())return false;
                if(c == '}' && st.peek() != '{')return false;
                if(c == ')' && st.peek() != '(')return false;
                if(c == ']' && st.peek() != '[')return false;
                st.pop();
            }
            
        }
        return st.empty();
    }
	
	
	//下面是21.合并两个有序链表
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	/*
	class Solution {
	    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        ListNode ln = new ListNode(0);
	        ListNode ln2 = ln;
	        
	        while(l1 != null && l2 !=null){
	            
	            if(l1.val >= l2.val){
	                ln.next = l2;
	                l2 = l2.next;
	            }else {
	                ln.next = l1;
	                l1 = l1.next;
	            }
	            ln = ln.next;
	        }
	        
	        
	        while(l1!=null && l2==null){
	            ln.next = l1;
	            l1 = l1.next;
	            ln = ln.next;
	        }
	        while(l2!=null && l1==null){
	            ln.next = l2;
	            l2 = l2.next;
	            ln = ln.next;
	        }
	        return ln2.next;
	        
	    }
	}
	
	*/
}
