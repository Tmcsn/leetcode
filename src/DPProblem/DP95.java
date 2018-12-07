package DPProblem;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }
public class DP95 {
//    public List<TreeNode> generateTrees(int n) {
//        List<TreeNode> result=new ArrayList<TreeNode>();
//        for(int i=0;i<n;i++){
//            for(int j=0;j<result.size();j++){
//                List<TreeNode> tmpList=new ArrayList<TreeNode>();
//                TreeNode tmp=result.get(j);
//                int count=1;
//                if(tmp.right!=null){
//                    count++;
//                    tmp=tmp.right;
//                }
//                for(int w=0;w<count;w++){
//                    TreeNode now=new TreeNode(n);
//                    now.left=tmp;
//                    tmpList.add(now);
//                }
//
//
//            }
//
//        }
//
//    }

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
                    TreeNode node=new TreeNode(i);
                    node.left=left;
                    node.right=right;
                    res.add(node);
                }
            }
        }
        return res;


    }
}
