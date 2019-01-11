#### 寻找两个树节点的最低公共祖先

解法1：

最直观的解法就是深度优先遍历整棵树 查看每一条完整的路径该路径上是否包含节点p或者节点q  如果包含则 返回ture

直到某一个节点其左右子树都返回true 或者其左右子树有一个返回true的同时 自身是p或者是q中的一个 那么该节点就是最小公共祖先节点

所以 解题重点如下 

1 如何遍历整棵树 找到 p 和 q所属的子树

2 如何确定返回的节点是哪一个节点

第一个问题 使用递归 深度优先遍历 寻找 p或q 是否在左右子树中存在

```
    public boolean recurseTree(TreeNode root,TreeNode p,TreeNode q){  // 将树分成左右子树分别处理 终止条件就是root等于null的时候 返回false   如果左子树 或者右子树 或者本身节点等于p或者q 返回true  同时三者中满足二者 则说明该节点是最低公共父节点
        if(root == null){  // 终止条件 
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
```

完整代码

```
class Solution {
     private TreeNode answer;
    public Solution(){
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
}
```

