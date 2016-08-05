public class Solution {
    // public String longestCommonPrefix(String[] strs) {
	   //     if(strs == null) {
	   //         return null;
	   //     }
	   //      if(strs.equals("") || strs.length == 0) {
	   //         return "";
	   //      }
	   //     int i = 0 ;
	   //     StringBuffer common = new StringBuffer();
	   //     String temp1= null;
	   //     String temp2 = null;
	   //     int length = strs[0].length();
	   //     for(String len : strs) {
	   //     	if(len.length() < length) {
	   //     		length = len.length();
	   //     	}
	   //     }
	   //     if(length == 0) {
	   //     	return "";
	   //     }
	   //     for(i = 0 ; i < length ; i ++) {

	   //     	temp1 = String.valueOf(strs[0].charAt(i));
	   //     	for(String s : strs) {
	        		
	   // 	        temp2 = String.valueOf(s.charAt(i));
	    	        
	   // 	        if(!temp2.equals(temp1)) {
	   // 	        	return common.toString();
	   // 	        }
		  //      }
	   //     	common.append(String.valueOf(temp1));
	   //     }
	        
	   //     return common.toString();
	   // }
	   public String longestCommonPrefix(String[] strs) {
        // write your code here
        if (strs == null) {
            return null;
        }
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int length = Math.min(strs[0].length(), strs[1].length());
        int i = 0;
        while (i < length && strs[0].charAt(i) == strs[1].charAt(i)) {
            i++;
        }
        String comm = strs[0].substring(0, i);
        int same = i;
        for (int m = 2; m < strs.length ; m++) {
            int j = 0;
            while (j < i && j < strs[m].length() && comm.charAt(j) == strs[m].charAt(j)) {
                j++;
            }
            if (j == 0) {
                return "";
            }
            if (j < same) {
                same = j;
            }
        }
        return comm.substring(0, same);
    }
}