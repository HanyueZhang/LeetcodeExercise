public class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] count = new int[256];
		int[] index = new int[256];
		for (int i = 0 ; i < s.length() ; i++) {
			count[s.charAt(i) - 'A'] += 1;
			index[s.charAt(i) - 'A'] = i;
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0 ; i < 256 ; i++) {
			if (count[i] == 1 && index[i] < result) {
				result = index[i];
			}
		}
		if (result != Integer.MAX_VALUE) {
			return result;
		}
		return -1;
    }
}