# Stone game

作为Weekly Contest的Medium难度题目 主要考察动态规划的知识

## 题目解析

Alex and Lee play a game with piles of stones.  There are an even number of piles **arranged in a row**, and each pile has a positive integer number of stones `piles[i]`.

The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.

Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.  This continues until there are no more piles left, at which point the person with the most stones wins.

Assuming Alex and Lee play optimally, return `True` if and only if Alex wins the game.



Example：

```
Input: [5,3,4,5]
Output: true
Explanation: 
Alex starts first, and can only take the first 5 or the last 5.
Say he takes the first 5, so that the row becomes [3, 4, 5].
If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
This demonstrated that taking the first 5 was a winning move for Alex, so we return true.
```

**Note:**

1. `2 <= piles.length <= 500`
2. `piles.length` is even.
3. `1 <= piles[i] <= 500`
4. `sum(piles)` is odd.

解析： 首先对于piles数组个数为偶数，总和为奇数 那么对于piles中奇数位置上数字只和不是大于就是小于偶数位置上的数字之和，同时对于先取的玩家而言可以控制只选取偶数位置上或者只选取奇数位置上的stone，因此最终结果一定是True

但是如果题目做了修改不能保证上述Note中的限定则解析中的思路就不在适用

利用动态规划的角度进行解析：

首先需要导出动态规划的递推公式

对于[i,j]中的元素，dp【i】【j】=max(piles[i]-dp[i+1]【j】,piles[j]-dp[i]【j-1】)

注：对于二维的动态规划数组，一定要注意dp【i】【i】具体代表的值，一般情况下该值需要单独的进行初始化。

同时两层循环的顺序 需要根据递推公式中出现的顺序确定是从前到后还是从后到前

其中dp[i]【j】代表的是从第i个元素到第j个元素先选者与后选者石头总和的最大差

（input[5,3]）dp【0】【1】=max（5-3,3-5）=2

（input [5,3,4]）dp【0】【2】=max（5-dp【1】【2】，4-dp【0】【1】）

（注意这时候虽然dp【0】【1】在理论上求的是先选者与后选者之间的最大差，但是在公式中减去的先选者的值其实在整体上是后选的那一个）

```
public   boolean stoneGame(int[] piles) {
        //使用动态规划
        int n=piles.length;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=piles[i];
        }
        for(int i= n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                dp[i][j]=Math.max(piles[i]-dp[i+1][j],piles[j]-dp[i][j-1]);
            }
        }
        return dp[0][n-1]>0;


    }
```

