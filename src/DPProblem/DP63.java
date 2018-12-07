package DPProblem;

/**
 *  注意边界值的处理 当obstacle 在[0][0]位置 以及 在 边缘位置对分布的影响
 */
public class DP63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m= obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        int[][] total=new int[m][n];
        total[0][0]=1;
        for(int i=1;i<m;i++){
            if (obstacleGrid[i][0] == 1 || total[i-1][0]==0){
                total[i][0]=0;
            }else{
                total[i][0]=1;
            }
        }
        for (int j=1;j<n;j++){
            if(obstacleGrid[0][j] == 1 || total[0][j-1]==0){
                total[0][j]=0;
            }else{
                total[0][j]=1;
            }
        }
        for(int i = 1;i<m;i++){
            for(int j=1;j<n;j++){
                total[i][j]= obstacleGrid[i][j]==1?0:total[i-1][j]+total[i][j-1];
            }
        }
        return total[m-1][n-1];

    }

    public static void main(String[] args) {
        int [][] a={{0,0,0},{0,1,0},{0,0,0}};
        DP63 d=new DP63();
        d.uniquePathsWithObstacles(a);
    }
}
