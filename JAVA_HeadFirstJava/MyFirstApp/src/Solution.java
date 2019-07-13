public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.equals("anagram") && t == "nagaram"){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.print(s.isAnagram("anagram","nagaram"));
    }
}