## DP 152 Maximum Product Subarray

#### 题目解析

```
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
```

给出一个数组 求连续最大子数组的乘积

#### 问题求解

遍历数组的时候 需要存储当前位置最大值 和 最小值

因为i位置可能为正也可能为负 因此 遍历到i位置的最大值只有可能是i值本身

或者是遍历到前i-1个值的时候 的最大值和当前值的乘积

或者是遍历前i-1 个值的时候的最小值和当前值的乘积

因此在遍历的过程中要存储当前最大值 当前最小值 和全局最大三个遍历 遍历过程中实时更新

```
 public int maxProduct(int[] nums) {
        int n=nums.length;
        if(n==0){
            return 0;
        }
        int globalMax=nums[0];
        int maxPre=nums[0];
        int minPre=nums[0];
        for(int i=1;i<n;i++){
            int tmpmaxPre=Math.max(nums[i],Math.max(nums[i]*maxPre,nums[i]*minPre));
            int tmpminPre=Math.min(nums[i],Math.min(nums[i]*maxPre,nums[i]*minPre));
            maxPre=tmpmaxPre;
            minPre=tmpminPre;
            globalMax=Math.max(globalMax,maxPre);
        }
        return globalMax;


        }
```

