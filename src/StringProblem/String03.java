package StringProblem;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class String03 {
    public static  int lengthOfLongestSubstring(String s) {
      int ans=0;
      HashMap<Character,Integer> hashMap=new HashMap<>();
      for(int i=0,j=0;j<s.length();j++){
          if(hashMap.containsKey(s.charAt(j))){
              i=Math.max(i,hashMap.get(s.charAt(j))+1);
          }
          ans=Math.max(ans,j-i+1);
          hashMap.put(s.charAt(j),j);
      }
      return ans;
    }
    public static void main(String[] args) {
           String example="bbbb";
           System.out.println(lengthOfLongestSubstring(example));
    }
}
