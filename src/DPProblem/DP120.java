package DPProblem;

import edu.princeton.cs.algs4.In;

import java.util.List;

public class DP120 {
    /**
     *  使用原始的triangle存储计算中间量  没有额外的空间损失
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int num=triangle.size();
        for(int i=num-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                int pre=Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1));
                int cur=triangle.get(i).get(j)+pre;
                triangle.get(i).set(j,cur);

            }
        }
        return triangle.get(0).get(0);

    }

    /**
     *  使用n*n的空间存储
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle){

        int m = triangle.size();
        int[][] result=new int[m][m];
        if(triangle.size()==0){
            return 0;
        }
        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }
        result[0][0]=triangle.get(0).get(0);
        int min= Integer.MAX_VALUE;
        for(int i=1;i<m;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    result[i][j]=result[i-1][j]+triangle.get(i).get(j); //在第一列只有可能是上一列传递下来
                }else if(j==i){
                    result[i][j]=result[i-1][j-1]+triangle.get(i).get(j);// 在最后一列因为 上一列对应的位置没有元素  因此只有可能是上一列的最后一个元素传递下来
                }else{
                    result[i][j]=Math.min(result[i-1][j-1],result[i-1][j])+triangle.get(i).get(j);
                }
                if(i==m-1){
                    min = Math.min(min,result[i][j]);
                }
            }
        }
        return min;

    }

    /**
     *  又到了将额外的二维数组转化为一维数组的时候了
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle){

        int  m = triangle.size();
        int[] result=new int[m];
        if(m==0){
            return 0;
        }
        if(m==1){
            return triangle.get(0).get(0);
        }
        int min=Integer.MAX_VALUE;
        result[0]=triangle.get(0).get(0);
        int pre=0;
        int after=0;
        for(int i=1;i<m;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    pre=result[0];
                    result[0]=result[0]+triangle.get(i).get(j);
                }else if(j==i){
                    result[j]=pre+triangle.get(i).get(j);

                }else {
                    after =result[j];
                    result[j]=Math.min(pre,after)+triangle.get(i).get(j);
                    pre=after;
                }
                if(i==m-1){
                    min=Math.min(result[j],min);
                }
            }
        }
        return min;

    }

}
