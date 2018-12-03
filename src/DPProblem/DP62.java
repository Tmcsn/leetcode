package DPProblem;

public class DP62 {

    /**
     *   Solutioon 1 因为只能向右或者向下移动 所以使用total[m][n] 每个位置记录到当前位置所有可能性
     *   total[i][0]和totoal[0][j]都是1 其他位置的可能性为该位置左侧和上册的加和
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] total=new int[m][n];
        for(int i=0;i<m;i++){
            total[i][0]=1;
        }
        for(int j=0;j<n;j++){
            total[0][j]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                total[i][j]=total[i-1][j]+total[i][j-1];
            }
        }
        return total[m-1][n-1];






    }

    /**
     *  out of time  超时的解法 递归计算过于复杂的时候 应该使用 循环代替
     * @param m
     * @param n
     * @return
     */
    public int  totalCount(int m ,int n){
        if(m==1 || n==1){
            return 1;
        }
        else
            return totalCount(m-1,n)+totalCount(m,n-1);



    }

}
