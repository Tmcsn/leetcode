package WeeklyContest.Contest95;

/**
 * Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].

 The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.

 Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.  This continues until there are no more piles left, at which point the person with the most stones wins.

 Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.

 note:
 2 <= piles.length <= 500
 piles.length is even.
 1 <= piles[i] <= 500
 sum(piles) is odd.
 */
public class StoneGame877 {
    public static  boolean stoneGame(int[] piles) {
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

    public static void main(String[] args) {
        int[]a={1,4,10,8,3,2,4,1};
        stoneGame(a);
    }
}
