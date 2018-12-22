## DP139 Word Break

#### 题目解析

```
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
```

给定一个数组和字符串 查看数组中的元素是否能够组成字符串的元素

#### 问题求解

动态规划的思想 一个字符串能否被数组中的元素表示 需要字符串的一个子串能够被数组中的元素表示 同时剩下的元素也能够被数组中的元素表示

对于子串如何划分 只能够通过遍历所有的可能

创建一个boolean 数组 位置i存放字符串前[0,i]的子串能否被数组中元素表示

字符串[0,i]能够被表示需要满足的条件是 i>j>=0  boolean[j]==True && substring(j+1,i+1) 在数组中



```
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
```

