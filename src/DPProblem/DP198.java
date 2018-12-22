package DPProblem;

public class DP198 {
    // 该题唯一有一些不容易想到的地方时只能间隔一户偷取一户
    // 那么这个间隔影响的范围究竟有多大 其实影响的范围是两户  因为为了获取最大值 最多只可能是间隔一户或者间隔两户偷取一次 如果是间隔三户的话
    // 就相当于白白浪费了中间一户的金额

    // 依然是动态规划的思想
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
        return Math.max(nums[n-1],nums[n-2]);




    }
}
