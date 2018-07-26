package StringProblem;

public class String05 {
    //动态规划获得回文字符串
    public static String longestPalindrome1(String s) {
         int start=0;
         int end=0;
         int n=s.length();
         boolean isPalindromel[][]=new boolean[n][n];
         for(int i=n-1;i>=0;i--){
             for(int j=i;j<n;j++){
                 if(s.charAt(i)==s.charAt(j) && (j-i)<=2){
                     isPalindromel[i][j]=true;
                     if(j-i+1>end-start+1){
                         start=i;
                         end=j;
                     }
                 }
                 if(s.charAt(i)==s.charAt(j)&& (j-i)>2&&isPalindromel[i+1][j-1]){
                     isPalindromel[i][j]=true;
                     if(j-i+1 >end-start+1){
                         start=i;
                         end=j;
                     }
                 }

             }
         }
         return s.substring(start,end+1);
    }



    // 寻找中间位置获得回文字符串
    public String longestPalindrome(String s) {
       int start=0;
       int end=0;
       int max=0;
       for(int i=0;i<s.length()-1;i++){
           int len1=getLength(s,i,i);
           int len2=getLength(s,i,i+1);
           int len=Math.max(len1,len2);
           if(len>max){
               max=len;
               start=i-(len-1)/2;
               end=i+len/2;
           }
       }
        return s.substring(start,end+1);
    }
   private int getLength(String s,int middleCharacterIndexBegin,int middleCharacterIndexEnd){
     while (middleCharacterIndexBegin>=0&&middleCharacterIndexEnd<s.length()&&s.charAt(middleCharacterIndexBegin)==s.charAt(middleCharacterIndexEnd)){
         middleCharacterIndexBegin--;
         middleCharacterIndexEnd++;
     }
     return middleCharacterIndexEnd-middleCharacterIndexBegin-1;
   }
    public static void main(String[] args) {
          String test="abababa";
          System.out.println(longestPalindrome1(test));
    }
}
