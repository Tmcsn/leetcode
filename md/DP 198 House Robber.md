## DP 198 House Robber

#### 题目解析

```
Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
```

对于一个正整数数组 从中选取不相邻的元素 使得选取到的元素最大

这也是一个典型的动态规划的问题 

一般情况下是从第一个元素开始 前n个元素最大或最小是多少 即选取到该元素时满足的题目条件 只不过选取到该元素的时候 它之前的元素都被选取比较过

而该题不一样的是 选取到该元素的时候不是整个问题的完全解 真正的解可能不会选取到该元素

不过只要选取到该元素时分支条件是有限的 那么我们可以通过比较有限的分支条件得到选取到该元素时满足目标的结果

这道题和 给n个台阶每次只能向上走一个台阶或者两个台阶有一点类似
n个台阶问题是遍历n 对于每一个位置i的最大值只可能是result[i-1]+1 或者result[i-2]+1
但是对于该题目是遍历n个位置 
该位置的值只可能是Math.max(result[i-2]+num[i],result[i-3]+num[i] )
同理对于最后的结果 也有两种选择 只可能是Math.max(reuslt[i],result[i-1])

#### 问题求解

以[10,2,3,7,9,4,6] 为例

对于 第一个元素 则选取到该元素最大值为10

第二个元素 选取到 该元素的最大值为 2

第三个元素 选取到该元素的最大值为 nums[2]+nums[2-2]

对于第四个元素 选取到该元素的最大值为 Math.max(nums[3]+nums[3-2],nums[3]+nums[3-3])

对于第5个元素 选到该元素最大值为 Math.max(nums[4]+nums[4-2],num[4]+nums[4-3])

（之所以最大值只有这两种可能 是因为 如果和它向量的3个元素都不选 选择间隔更大的 那么相当于白白丢失了一个加正值的机会 肯定不会得到最大值）

以此类推 

最终的结果会在nums[n-i]和num[n-2]中产生

（因为如果不是在这两个中产生 比如在nums[n-3]中 那么相当于白白丢失了nums[n-1]的值）

```
  public int rob(int[] nums) {
        int n =nums.length;
        if(n==0){
            return 0;
        }
         if(n==1){
            return nums[0];
        }
         if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        for(int i=2;i<n;i++){
            if(i==2){
                nums[i]=nums[i-2]+nums[i];
            }else{
                nums[i]=Math.max(nums[i-2]+nums[i],nums[i-3]+nums[i]);
            }
        }
        }
        return Math.max(nums[n-1],nums[n-2]);
```

