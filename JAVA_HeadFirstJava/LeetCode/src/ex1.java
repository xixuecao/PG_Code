// Valid Anagram

public class ex1 {
		public boolean isAnagram(String s, String t) {
		    	if(s.equals(t))
		            return true;
		        if(s==null||t==null||s.length()!=t.length())
		            return false;
		        int[] num=new int[26];
		        for(int i=0;i<s.length();i++){
		            num[s.charAt(i)-'a']++;
		            num[t.charAt(i)-'a']--;
		        }
		        for(int i:num ){
		            if(i!=0)
		                return false;
		        }
		        return true;		        
		}

    public static void main(String[] args){
        ex1 s = new ex1();
        System.out.print(s.isAnagram("anagram","nagaram"));
    }
}