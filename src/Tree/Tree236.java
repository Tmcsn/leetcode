package Tree;

import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Tree236 {
    private TreeNode answer;
    public Tree236(){
        this.answer=null;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        recurseTree(root,p,q);
        return this.answer;
    }
    public boolean recurseTree(TreeNode root,TreeNode p,TreeNode q){
        if(root == null){
            return  false;
        }
        int left=recurseTree(root.left,p,q)?1:0;
        int right=recurseTree(root.right,p,q)?1:0;
        int mid= (root == p || root == q)?1:0;
        if(left+right+mid >=2){
            this.answer=root;
        }
        return (left+right+mid)>0;

    }

    public static void main(String[] args) {
        boolean a=true;
        boolean b=true;
        boolean c=false;
        System.out.println(a+b+c);
    }

}
