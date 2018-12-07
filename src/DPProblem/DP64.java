package DPProblem;

public class DP64 {
    /**
     *  使用二维数组对数据进行存储 处理的关键就是将第一行和第一列这些无法选择的路径首先计算 然后逐行进行计算
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n=grid[0].length;
        int[][]mintotal=new int[m][n];
        mintotal[0][0]=grid[0][0];
        for (int i=1;i<m;i++){
            mintotal[i][0]=mintotal[i-1][0]+grid[i][0];
        }
        for (int j=1;j<n;j++){
            mintotal[0][j]=mintotal[0][j-1]+grid[0][j];
        }
        for(int i=1 ;i<m;i++){
            for(int j=1;j<n;j++){
                mintotal[i][j]=grid[i][j]+Math.min(mintotal[i-1][j],mintotal[i][j-1]);
            }
        }
        return mintotal[m-1][n-1];

    }

    /**
     * 修改额外的空间为一维数组 时间复杂度不变  空间复杂度降低
     * @return
     */
    public int minPathSum2(int [][]grid){
        int m = grid.length;
        int n=grid[0].length;
        int[] minTotal=new int[n];
        minTotal[0]=grid[0][0];
        for (int i=1;i<n;i++){
            minTotal[i]=minTotal[i-1]+grid[0][i];
        }
        for (int j=1;j<m;j++){
            minTotal[0]=minTotal[0]+grid[j][0];
            for (int i=1;i<n;i++){
                minTotal[i]=Math.min(minTotal[i],minTotal[i-1])+grid[j][i];
            }
        }
        return minTotal[n-1];
    }
}
