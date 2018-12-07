## Unique Binary Search Trees II

#### 一.题目解析

给出n个点 输出着n个点能够组成的所有二叉查找树

#### 二.解题思路

可以借用Unique Binary Search Trees解题思路  每个点分别选取作为根节点 例如第i个点作为根节点  (1,i-1) 构造左子树  （i+1，n）构造右子树

即 getGenerateTrees(int start,int end)  

终止条件 start>end

又转化为基础的动态规划问题

```
class Solution {
     public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result=new ArrayList<TreeNode>();
        if(n<=0){
            return result;
        }
        result=getGenerateTrees(1,n);
        return result;
    }
    public List<TreeNode> getGenerateTrees(int start,int end){
        List<TreeNode> res=new ArrayList<TreeNode>();
        if(start>end){
            res.add(null);
            return res;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> lefts=getGenerateTrees(start,i-1);
            List<TreeNode> rights=getGenerateTrees(i+1,end);
            
            for (TreeNode left:lefts){
                for(TreeNode right:rights){
                    TreeNode node=new TreeNode(i); //所有的左子树和右子树的组合
                    node.left=left;
                    node.right=right;
                    res.add(node);
                }
            }
        }
        return res;


    }
}
```

