package ValidAnagram;

/**
 * 有效的回文构词法
 * @author wangfei
 *
 */
public class Solution {

	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		System.out.println(isAnagram(s, t));
	}
	
	/**
	 * 将26个小写字母映射到长度为26的数组中去，s字符串中存在某个字母时对应位置的数组中加1，
	 * t字符串中存在某个字母时对应位置的数组中减1，最后遍历数组元素，若存在不为0的数组值，
	 * 则返回false,否则返回true
	 * 时间复杂度为O(N)
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isAnagram(String s, String t) {
		if(s == null || t== null || (s.length() != t.length()))
			return false;
		int[] arr = new int[26];
		for(int i=0; i<s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
			arr[t.charAt(i) - 'a']--;
		}
		for(int i : arr) {        //遍历数组中的所有元素
			if(i != 0)
				return false;
		}
		return true;
	}
}
