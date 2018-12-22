package DPProblem;

import java.util.List;

public class DP139 {
    /***
     *  题目的意思是看能不能由这几个wordDict里面的候选项组成s
     *  这里需要注意的是两个循环遍历的意义
     *  外层循环是限制遍历的截止字符
     *  内层循环是限制遍历的开始字符
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.size()==0){
            return false;
        }
        int len=s.length();
        boolean[] result=new boolean[len];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                String sub=s.substring(j,i+1);
                if(wordDict.contains(sub) &&(j==0 || result[j-1] )){
                    result[i]=true;
                    break;
                }

            }

        }
        return result[len-1];

    }
}
