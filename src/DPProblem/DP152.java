package DPProblem;

import java.util.Arrays;

/**
 *   该题最开始的由于理解错误 所以产生了一个错误的解法
 *   使用一个数组 result存储当前位置的最大值
 *   遍历原始数组 如果当前位置的值nums[i]和 result[i-1] 的值异号  则result[i] 存储为nums[i]的值
 *   问题就出现在这里 因为此时同号相乘肯定是最大 但是 如果是异号则为最小 应该也需要存储下来 因为如果result[i+1] 和最小值符号相同 那么这时候得到的就是最大值
 *
 *   所以问题的核心是 遍历数组 对于位置i 得到之前所有的最大值和最小值 在位置i处得到的前i 个数中连乘最大只有可能是三种情况
 *   nums[i] 本身  nums[i]* maxPre   nums[i]*minPre 中的一种
 */
public class DP152 {


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


    public static void main(String[] args) {
        int[]a={2,3,-4};
        DP152 dp=new DP152();
        dp.maxProduct(a);
    }
}
